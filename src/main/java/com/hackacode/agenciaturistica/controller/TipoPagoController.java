package com.hackacode.agenciaturistica.controller;

import com.hackacode.agenciaturistica.dto.TipoPagoDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.ITipoPagoService;
import com.hackacode.agenciaturistica.service.ITipoServicio;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipopago")
public class TipoPagoController {


    @Autowired
    private ITipoPagoService  tipoServ;

    @Operation(summary = "Devuelve los tipos de pago",
            description = "Devvuelve una lista con todos los tipos de pago que existen")

    @GetMapping("/all")
    public List<TipoPagoDTO> getAll(){

        return tipoServ.getAll();
    }

    @Operation(summary = "Devuelve un tipo de pago",
            description = "Devuelve un tipo de pago por id")


    @GetMapping("/{id_tipo}")
    public TipoPagoDTO getTipoPagoById(@PathVariable Long id_tipo)throws IdNotFoundException {

        return tipoServ.getTipoPagoById(id_tipo) ;
    }

    @Operation(summary = "Guarda un tipo de pago",
            description = "Permite guardar un nuevo  tipo de pago")


    @PostMapping("/save")
    public TipoPagoDTO saveTipoPago(@Valid @RequestBody TipoPagoDTO tipoPago) throws HibernateOperationException {

        return tipoServ.saveTipoPago(tipoPago);
    }

}
