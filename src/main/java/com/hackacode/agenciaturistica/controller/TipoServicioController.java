package com.hackacode.agenciaturistica.controller;

import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.ITipoServicio;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposervicio")
public class TipoServicioController {

    @Autowired
    private ITipoServicio tipoServ;


    @GetMapping("/all")
    public List<TipoServicioDTO> getAll(){

        return tipoServ.getAll();
    }


    @GetMapping("/{id_problem}")
    public TipoServicioDTO getProblemById(@PathVariable Long id_tipo)throws IdNotFoundException {

        return tipoServ.getTipoServicioById(id_tipo);
    }


    @PostMapping("/save")
    public TipoServicioDTO saveProblem(@Valid @RequestBody TipoServicioDTO tipoSericio) throws HibernateOperationException {

        return tipoServ.saveTipoSercicio(tipoSericio);
    }

}
