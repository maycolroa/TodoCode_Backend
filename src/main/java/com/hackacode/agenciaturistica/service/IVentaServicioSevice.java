package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaServicioReqDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IVentaServicioSevice {

    public List<VentaServicioResDTO> getAll();

    public VentaServicioResDTO getVentaServicioById(Long id_venta) throws IdNotFoundException;

    public VentaServicioResDTO saveVentaServicio (VentaServicioReqDTO ventaServicio) throws HibernateOperationException;


}
