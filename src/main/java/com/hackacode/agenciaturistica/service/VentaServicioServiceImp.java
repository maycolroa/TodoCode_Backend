package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaServicioReqDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.Pago;
import com.hackacode.agenciaturistica.model.Servicio;
import com.hackacode.agenciaturistica.model.VentaPaquete;
import com.hackacode.agenciaturistica.model.VentaServicio;
import com.hackacode.agenciaturistica.repository.IVentaServicioRepository;
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
public class VentaServicioServiceImp implements IVentaServicioSevice{

    private static final Logger logger = LoggerFactory.getLogger(VentaServicioServiceImp.class);
    @Autowired
    private IMyFactory myFactoryServ;


    @Autowired
    private IVentaServicioRepository ventaServicioRepo;


    @Autowired
    private IServicioService servicioServ;



    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<VentaServicioResDTO> getAll() {

        var ventasServicioBD = ventaServicioRepo.findAll();
        var ventasServiciosDTO = new ArrayList<VentaServicioResDTO>();

        for (VentaServicio ventaservicio : ventasServicioBD){
            ventasServiciosDTO.add(modelMapper.map(ventaservicio, VentaServicioResDTO.class));

        }

        return ventasServiciosDTO;

    }

    @Override
    public VentaServicioResDTO getVentaServicioById(Long id_venta) throws IdNotFoundException {

        VentaServicio ventaServicio= ventaServicioRepo.findById(id_venta).orElseThrow(() -> new IdNotFoundException("El id " + id_venta + " no se encuentra registrado"));

        var ventaSerciioDto = modelMapper.map(ventaServicio, VentaServicioResDTO.class);


        return ventaSerciioDto;
    }

    @Override
    public VentaServicioResDTO saveVentaServicio(VentaServicioReqDTO ventaServicio) throws HibernateOperationException {




        try{


            var servicio = servicioServ.saveServicio(ventaServicio.getServicio());
            logger.info("Se hace un save del servicio:", servicio);




            Object entidadVentaServicio = myFactoryServ.crearEntidad("com.hackacode.agenciaturistica.model.VentaServicio");
            VentaServicio ventaSer= (VentaServicio) entidadVentaServicio;


            ventaSer.setFecha_venta(ventaServicio.getFecha_venta());
            ventaSer.setCliente(ventaServicio.getCliente());
            ventaSer.setEmpleado(ventaServicio.getEmpleado() );
            ventaSer.setServicio(modelMapper.map(servicio, Servicio.class));
            var ventaserviciosave = ventaServicioRepo.save(ventaSer);
            logger.info("Se realiza una venta de un servicio:", ventaserviciosave );



        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }



        return new VentaServicioResDTO();
    }
}
