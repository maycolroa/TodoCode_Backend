package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.TipoPagoDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface ITipoPagoService {

    public List<TipoPagoDTO> getAll();

    public TipoPagoDTO getTipoPagoById(Long id_tipo) throws IdNotFoundException;

    public TipoPagoDTO saveTipoPago (TipoPagoDTO tipoPago) throws HibernateOperationException;

}
