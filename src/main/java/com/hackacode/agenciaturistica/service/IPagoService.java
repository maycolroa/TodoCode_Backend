package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PagoReqDTO;
import com.hackacode.agenciaturistica.dto.PagoResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IPagoService {

    public List<PagoResDTO> getAll();

    public PagoResDTO getPagoById(Long id_pago) throws IdNotFoundException;


    public PagoResDTO savePagoServicio(@Valid @RequestBody PagoReqDTO pago) throws HibernateOperationException ;


    public PagoResDTO savePagoPaquete(@Valid @RequestBody PagoReqDTO pago) throws HibernateOperationException ;

}
