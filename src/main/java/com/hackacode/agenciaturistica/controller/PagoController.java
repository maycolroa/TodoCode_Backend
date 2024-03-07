package com.hackacode.agenciaturistica.controller;


import com.hackacode.agenciaturistica.dto.PagoReqDTO;
import com.hackacode.agenciaturistica.dto.PagoResDTO;
import com.hackacode.agenciaturistica.dto.TipoPagoDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.IPagoService;
import com.hackacode.agenciaturistica.service.ITipoPagoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pago")
public class PagoController {

    @Autowired
    private IPagoService poServ;

    @Operation(summary = "Devuelve los tipos de pago",
            description = "Devvuelve una lista con todos los tipos de pago que existen")

    @GetMapping("/all")
    public List<PagoResDTO> getAll(){

        return poServ.getAll();
    }

    @Operation(summary = "Devuelve un tipo de pago",
            description = "Devuelve un tipo de pago por id")


    @GetMapping("/{id_tipo}")
    public PagoResDTO getTipoPagoById(@PathVariable Long id_tipo)throws IdNotFoundException {

        return poServ.getPagoById(id_tipo) ;
    }

    @Operation(summary = "Guarda un tipo de pago",
            description = "Permite guardar un nuevo  tipo de pago")


    @PostMapping("/saveservicio")
    public PagoResDTO savePagoServicio(@Valid @RequestBody PagoReqDTO pago) throws HibernateOperationException {

        return poServ.savePagoServicio(pago);
    }


    @PostMapping("/save")
    public PagoResDTO savePagoPaquete(@Valid @RequestBody PagoReqDTO pago) throws HibernateOperationException {

        return poServ.savePagoPaquete(pago) ;
    }

}
