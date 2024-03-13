package com.hackacode.agenciaturistica.controller;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
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

    @Operation(summary = "Devuelve los tipos de de servicio",
            description = "Devvuelve una lista con todos los tipos de servicio que existen")

    @GetMapping("/all")
    public List<TipoServicioDTO> getAll(){

        return tipoServ.getAll();
    }

    @Operation(summary = "Devuelve un tipo de servicio",
            description = "Devuelve un tipo de servicio por id")



    @GetMapping("/{id_tipo}")
    public TipoServicioDTO getTipoServicioById(@PathVariable Long id_tipo)throws IdNotFoundException {

        return tipoServ.getTipoServicioById(id_tipo);
    }

    @Operation(summary = "Guarda un tipo de servicio",
            description = "Permite guardar un nuevo  tipo de servicio")

    @PostMapping("/save")
    public TipoServicioDTO saveTipoServicio(@Valid @RequestBody TipoServicioDTO tipoSericio) throws HibernateOperationException {

        return tipoServ.saveTipoSercicio(tipoSericio);
    }




    @PutMapping("/{id_tipo}")
    public TipoServicioDTO editTipoServicio(@PathVariable Long id_tipo, @RequestBody TipoServicioDTO tipoServicioDTO) throws HibernateOperationException, IdNotFoundException {
        return tipoServ.editTipoServicio(id_tipo, tipoServicioDTO);
    }

    @DeleteMapping("/{id_tipo}")
    public void deleteTipoServicioById(@PathVariable Long id_tipo) throws IdNotFoundException {
        this.tipoServ.deleteTipoServicioById(id_tipo);
    }

}
