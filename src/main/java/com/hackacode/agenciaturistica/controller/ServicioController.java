package com.hackacode.agenciaturistica.controller;


import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.IServicioService;
import com.hackacode.agenciaturistica.service.ITipoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {


    @Autowired
    private IServicioService servicioServ;


    @GetMapping("/all")
    public List<ServicioDTO> getAll(){

        return servicioServ.getAll();
    }


    @GetMapping("/{id_servicio}")
    public ServicioDTO getProblemById(@PathVariable Long id_servicio)throws IdNotFoundException {

        return servicioServ.getServicioById(id_servicio);
    }


    @PostMapping("/save")
    public ServicioDTO saveProblem(@Valid @RequestBody ServicioDTO servicio) throws HibernateOperationException {

        return servicioServ.saveServicio(servicio);
    }


}
