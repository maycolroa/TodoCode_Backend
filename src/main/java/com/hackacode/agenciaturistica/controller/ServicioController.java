package com.hackacode.agenciaturistica.controller;


import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.IServicioService;
import com.hackacode.agenciaturistica.service.ITipoServicio;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {


    @Autowired
    private IServicioService servicioServ;


    @Operation(summary = "Retorna todos los servicios",
            description = "Retorna todos los servicio")

    @GetMapping("/all")
    public List<ServicioDTO> getAll(){

        return servicioServ.getAll();
    }


    @Operation(summary = "Obtiene un servicio por id_servicio",
            description = "Obtiene un servicio por id_servicio")

    @GetMapping("/{id_servicio}")
    public ServicioDTO getServicioById(@PathVariable Long id_servicio)throws IdNotFoundException {

        return servicioServ.getServicioById(id_servicio);
    }


    @Operation(summary = "Realiza el save de un servicio",
            description = "Realiza el save de un nuevo servicio")

    @PostMapping("/save")
    public ServicioDTO saveServicio(@Valid @RequestBody ServicioDTO servicio) throws HibernateOperationException {

        return servicioServ.saveServicio(servicio);
    }

    @Operation(summary = "Realiza el uptate de un servicio",
            description = "Realiza el update de un nuevo servicio")

    @PutMapping("/{id_servicio}")
    public ServicioDTO editServicio(@PathVariable Long id_servicio, @RequestBody ServicioDTO servicioDTO) throws HibernateOperationException, IdNotFoundException{
        return servicioServ.editServicio(id_servicio, servicioDTO);
    }

    @Operation(summary = "Realiza el delete de un servicio",
            description = "Realiza el delete de un nuevo servicio")

    @DeleteMapping("/{id_servicio}")
    public void deleteServicioById(@PathVariable Long id_servicio) throws IdNotFoundException {
        this.servicioServ.deleteServicioById(id_servicio);
    }


}
