package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IVentaServicioSevice {

    public List<VentaServicioDTO> getAll();

    public VentaServicioDTO getVentaServicioById(Long id_venta) throws IdNotFoundException;

    public VentaServicioDTO saveVentaServicio (VentaServicioDTO ventaServicio) throws HibernateOperationException;


}
