package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PagoDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IPagoService {

    public List<PagoDTO> getAll();

    public PagoDTO getPagoById(Long id_pago) throws IdNotFoundException;

    public PagoDTO savePago (PagoDTO apgo) throws HibernateOperationException;

}
