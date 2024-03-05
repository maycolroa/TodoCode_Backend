package com.hackacode.agenciaturistica.controller;


import com.hackacode.agenciaturistica.dto.VentaPaqueteResDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioReqDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.IVentaPaqueteService;
import com.hackacode.agenciaturistica.service.IVentaServicioSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaServicioSevice ventaServ;

    @Autowired
    private IVentaPaqueteService  ventaPaqueteServ;



    @GetMapping("/allservicios")
    public List<VentaServicioResDTO> getAllSericios(){

        return ventaServ.getAll();
    }


    @GetMapping("/allpaquetes")
    public List<VentaPaqueteResDTO> getAllPaquetes(){

        return ventaPaqueteServ.getAll();
    }



    @GetMapping("/{id_venta_servicio}")
    public VentaServicioResDTO getVentaServidioById(@PathVariable Long id_venta_servicio)throws IdNotFoundException {

        return ventaServ.getVentaServicioById(id_venta_servicio);
    }



    @GetMapping("/{id_venta_paquete}")
    public VentaPaqueteResDTO getProblemById(@PathVariable Long id_venta_paquete)throws IdNotFoundException {

        return ventaPaqueteServ.getVentaPaqueteById(id_venta_paquete) ;
    }



    @PostMapping("/saveservicio")
    public VentaServicioResDTO saveVentaServicio(@Valid @RequestBody VentaServicioReqDTO ventaServicioDto) throws HibernateOperationException {

        return ventaServ.saveVentaServicio(ventaServicioDto);
    }

    @PostMapping("/savepaquete")
    public VentaPaqueteResDTO saveVentaPaquete(@Valid @RequestBody VentaPaqueteResDTO ventaPaqueteDto) throws HibernateOperationException {

        return ventaPaqueteServ.saveVentaPaquete(ventaPaqueteDto);
    }




}
