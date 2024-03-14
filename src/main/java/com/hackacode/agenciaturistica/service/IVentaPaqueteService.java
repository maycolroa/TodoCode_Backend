package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaPaqueteReqDTO;
import com.hackacode.agenciaturistica.dto.VentaPaqueteResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IVentaPaqueteService {

    public List<VentaPaqueteResDTO> getAll();

    public VentaPaqueteResDTO getVentaPaqueteById(Long id_venta) throws IdNotFoundException;

    public VentaPaqueteResDTO saveVentaPaquete (VentaPaqueteReqDTO ventaPaqueteServicio) throws HibernateOperationException;
}
