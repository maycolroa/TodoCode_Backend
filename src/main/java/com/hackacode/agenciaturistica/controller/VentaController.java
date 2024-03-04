package com.hackacode.agenciaturistica.controller;


import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.dto.VentaPaqueteDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.repository.IVentaPaqueteRepository;
import com.hackacode.agenciaturistica.repository.IVentaServicioRepository;
import com.hackacode.agenciaturistica.service.ITipoServicio;
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
    public List<VentaServicioDTO> getAllSericios(){

        return ventaServ.getAll();
    }


    @GetMapping("/allpaquetes")
    public List<VentaPaqueteDTO> getAllPaquetes(){

        return ventaPaqueteServ.getAll();
    }



    @GetMapping("/{id_venta_servicio}")
    public VentaServicioDTO getVentaServidioById(@PathVariable Long id_venta_servicio)throws IdNotFoundException {

        return ventaServ.getVentaServicioById(id_venta_servicio);
    }



    @GetMapping("/{id_venta_paquete}")
    public VentaPaqueteDTO  getProblemById(@PathVariable Long id_venta_paquete)throws IdNotFoundException {

        return ventaPaqueteServ.getVentaPaqueteById(id_venta_paquete) ;
    }



    @PostMapping("/saveservicio")
    public VentaServicioDTO saveVentaServicio(@Valid @RequestBody VentaServicioDTO ventaServicioDto) throws HibernateOperationException {

        return ventaServ.saveVentaServicio(ventaServicioDto);
    }

    @PostMapping("/savepaquete")
    public VentaPaqueteDTO saveVentaPaquete(@Valid @RequestBody VentaPaqueteDTO ventaPaqueteDto) throws HibernateOperationException {

        return ventaPaqueteServ.saveVentaPaquete(ventaPaqueteDto);
    }




}
