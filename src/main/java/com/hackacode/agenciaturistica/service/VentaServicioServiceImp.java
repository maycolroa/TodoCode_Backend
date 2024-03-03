package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.repository.ITipoServicioRepository;
import com.hackacode.agenciaturistica.repository.IVentaServicioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VentaServicioServiceImp implements IVentaServicioSevice{

    @Autowired
    private IVentaServicioRepository ventaServicioRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<VentaServicioDTO> getAll() {
        return null;
    }

    @Override
    public VentaServicioDTO getVentaServicioById(Long id_venta) throws IdNotFoundException {
        return null;
    }

    @Override
    public VentaServicioDTO saveVentaServicio(VentaServicioDTO ventaServicio) throws HibernateOperationException {
        return null;
    }
}
