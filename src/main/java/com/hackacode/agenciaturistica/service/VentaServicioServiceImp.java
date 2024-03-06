package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaServicioReqDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.Pago;
import com.hackacode.agenciaturistica.model.Servicio;
import com.hackacode.agenciaturistica.model.VentaServicio;
import com.hackacode.agenciaturistica.repository.IVentaServicioRepository;
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


            var servicioDto = servicioServ.getServicioById(ventaServicio.getServicio().getCodigo_servicio() ) ;
            var servicio = modelMapper.map(servicioDto, Servicio.class);

            var montoTotal = servicio.getCosto() ;

            logger.info("Se le pide el costo al servicio :", servicio);



            Pago pago = new Pago();
            pago.setMontoTotal(montoTotal);
            pago.setTipoPago(ventaServicio.getTipoPago());
            pago.setFechaPago(LocalDateTime.now());
            logger.info("Se crea el pago correspondiente a la venta :", pago);


            VentaServicio ventaSer = new VentaServicio();
            ventaSer.setFecha_venta(ventaServicio.getFecha_venta());
            ventaSer.setPago(pago);
            ventaSer.setCliente(ventaServicio.getCliente());
            ventaSer.setEmpleado(ventaServicio.getEmpleado() );
            var ventaserviciosave = ventaServicioRepo.save(ventaSer);
            logger.info("Venta, was saved:", ventaserviciosave );



        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }



        return new VentaServicioResDTO();
    }
}
