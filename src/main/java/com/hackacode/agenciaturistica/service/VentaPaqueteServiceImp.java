package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaPaqueteResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.*;
import com.hackacode.agenciaturistica.repository.IVentaPaqueteRepository;
import com.hackacode.agenciaturistica.util.IMyFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaPaqueteServiceImp implements IVentaPaqueteService{

    private static final Logger logger = LoggerFactory.getLogger(VentaServicioServiceImp.class);

    @Autowired
    private IMyFactory  myFactoryServ;


    @Autowired
    private IVentaPaqueteRepository ventaPaqueteRepo;


    @Autowired
    private IPaqueteTuristicoService paqueteServ;



    @Autowired
    private ModelMapper modelMapper;



    @Override
    public List<VentaPaqueteResDTO> getAll() {
        var ventaspaquetesBD = ventaPaqueteRepo.findAll();
        var ventaspaquetesDTO = new ArrayList<VentaPaqueteResDTO>();

        for (VentaPaquete ventapaquete : ventaspaquetesBD){
            ventaspaquetesDTO.add(modelMapper.map(ventapaquete, VentaPaqueteResDTO.class));

        }

        return ventaspaquetesDTO;

    }

    @Override
    public VentaPaqueteResDTO getVentaPaqueteById(Long id_ventapaquete) throws IdNotFoundException{
        VentaPaquete ventaPaquete= ventaPaqueteRepo.findById(id_ventapaquete).orElseThrow(() -> new IdNotFoundException("El id " + id_ventapaquete + " no se encuentra registrado"));

        var ventaPaqueteDto = modelMapper.map(ventaPaquete, VentaPaqueteResDTO.class);


        return ventaPaqueteDto;
    }

    @Override
    public VentaPaqueteResDTO saveVentaPaquete (VentaPaqueteResDTO ventaPaqueteServicio) throws HibernateOperationException {
        var ventapaquetesave = modelMapper.map(ventaPaqueteServicio, VentaPaquete.class);

        try{


            var paqueteDto = paqueteServ.getPaqueteById(ventaPaqueteServicio.getPaquete() .getCodigo_paquete());
            var paquete = modelMapper.map(paqueteDto, PaqueteTuristico.class);

            logger.info("Se crea el pago correspondiente a la venta :", pago);



            Object entidadVentaPaquete = myFactoryServ.crearEntidad("com.hackacode.agenciaturistica.model.VentaPaquete");
            VentaPaquete ventaPaquete= (VentaPaquete) entidadVentaPaquete;


            ventaPaquete.setFecha_venta(ventaPaqueteServicio.getFecha_venta());
            ventaPaquete.setCliente(ventaPaqueteServicio.getCliente());
            ventaPaquete.setEmpleado(ventaPaqueteServicio.getEmpleado() );
            var ventaserviciosave = ventaPaqueteRepo.save(ventaPaquete);
            logger.info("Venta, was saved:", ventaserviciosave );


            ventapaquetesave = ventaPaqueteRepo.save(ventapaquetesave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var ventaPaqueteDtoSave = modelMapper.map(ventapaquetesave , VentaPaqueteResDTO.class);

        return ventaPaqueteDtoSave;
    }
}
