package com.hackacode.agenciaturistica.controller;


import com.hackacode.agenciaturistica.dto.VentaPaqueteReqDTO;
import com.hackacode.agenciaturistica.dto.VentaPaqueteResDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioReqDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.IVentaPaqueteService;
import com.hackacode.agenciaturistica.service.IVentaServicioSevice;
import io.swagger.v3.oas.annotations.Operation;
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


    @Operation(summary = "Devuelve todas ventas de servicios",
              description = "Devuelve un listado de todas las ventas de servicios que se han realizado")
    @GetMapping("/allservicios")
    public List<VentaServicioResDTO> getAllSericios(){

        return ventaServ.getAll();
    }

    @Operation(summary = "Devuelve todas ventas de los paquetes",
            description = "Devuelve un listado de todas las ventas de paquetes turisticos que se han realizado")

    @GetMapping("/allpaquetes")
    public List<VentaPaqueteResDTO> getAllPaquetes(){

        return ventaPaqueteServ.getAll();
    }


    @Operation(summary = "Devuelve una una venta de un servicio en particular",
            description = "Devvuelve una venta de un servicio, que se corresponde con el código de servicio que se le provee")

    @GetMapping("/{id_venta_servicio}")
    public VentaServicioResDTO getVentaServidioById(@PathVariable Long id_venta_servicio)throws IdNotFoundException {

        return ventaServ.getVentaServicioById(id_venta_servicio);
    }


    @Operation(summary = "Devuelve una una venta de un paquete en particular",
            description = "Devvuelve una venta de un paquete, que se corresponde con el código de paquete que se le provee")

    @GetMapping("/{id_venta_paquete}")
    public VentaPaqueteResDTO getProblemById(@PathVariable Long id_venta_paquete)throws IdNotFoundException {

        return ventaPaqueteServ.getVentaPaqueteById(id_venta_paquete) ;
    }



    @PostMapping("/saveventaservicio")
    public VentaServicioResDTO saveVentaServicio(@Valid @RequestBody VentaServicioReqDTO ventaServicioDto) throws HibernateOperationException {

        return ventaServ.saveVentaServicio(ventaServicioDto);
    }

    @PostMapping("/savepaquete")
    public VentaPaqueteResDTO saveVentaPaquete(@Valid @RequestBody VentaPaqueteReqDTO ventaPaqueteDto) throws HibernateOperationException {

        return ventaPaqueteServ.saveVentaPaquete(ventaPaqueteDto);
    }




}
