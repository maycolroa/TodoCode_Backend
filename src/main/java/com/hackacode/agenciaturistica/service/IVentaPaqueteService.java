package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaPaqueteDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IVentaPaqueteService {

    public List<VentaPaqueteDTO> getAll();

    public VentaPaqueteDTO getVentaPaqueteById(Long id_venta) throws IdNotFoundException;

    public VentaPaqueteDTO saveVentaPaquete (VentaPaqueteDTO ventaPaqueteServicio) throws HibernateOperationException;


}
