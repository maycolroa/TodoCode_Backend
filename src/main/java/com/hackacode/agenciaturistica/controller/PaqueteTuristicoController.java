package com.hackacode.agenciaturistica.controller;


import com.hackacode.agenciaturistica.dto.PaqueteTuristicoDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.PaqueteTuristicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paquete")
public class PaqueteTuristicoController {

    @Autowired
    private PaqueteTuristicoService paqueteTuristicoService;

    @GetMapping("/all")
    public List<PaqueteTuristicoDTO> getAllPaquetesTuristicos(){
        return paqueteTuristicoService.getAllPaquetesTuristicos();
    }

    @GetMapping("/{codigoPaquete}")
    public PaqueteTuristicoDTO getPaqueteTuristicoById(@PathVariable Long codigoPaquete) throws IdNotFoundException {
        return paqueteTuristicoService.getPaqueteTuristicoById(codigoPaquete);
    }

    @PostMapping("/save")
    public PaqueteTuristicoDTO savePaqueteTuristico(@Valid @RequestBody PaqueteTuristicoDTO paqueteTuristicoDTO) throws HibernateOperationException {
        return paqueteTuristicoService.savePaqueteTuristico(paqueteTuristicoDTO);
    }

    @PutMapping("/{codigoPaquete}")
    public PaqueteTuristicoDTO editPaqueteTuristico(@PathVariable Long codigoPaquete, @RequestBody PaqueteTuristicoDTO paqueteTuristicoDTO) throws HibernateOperationException, IdNotFoundException {
        return paqueteTuristicoService.editPaqueteTuristico(codigoPaquete, paqueteTuristicoDTO);
    }

    @DeleteMapping("/{codigoPaquete}")
    public void deletePaqueteTuristicoById(@PathVariable Long codigoPaquete) throws IdNotFoundException {
        this.paqueteTuristicoService.deletePaqueteTuristicoById(codigoPaquete);
    }
}
