package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaPaqueteDTO;
import com.hackacode.agenciaturistica.dto.VentaServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.VentaPaquete;
import com.hackacode.agenciaturistica.model.VentaServicio;
import com.hackacode.agenciaturistica.repository.ITipoServicioRepository;
import com.hackacode.agenciaturistica.repository.IVentaServicioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class VentaServicioServiceImp implements IVentaServicioSevice{

    @Autowired
    private IVentaServicioRepository ventaServicioRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<VentaServicioDTO> getAll() {

        var ventasServicioBD = ventaServicioRepo.findAll();
        var ventasServiciosDTO = new ArrayList<VentaServicioDTO>();

        for (VentaServicio ventaservicio : ventasServicioBD){
            ventasServiciosDTO.add(modelMapper.map(ventaservicio, VentaServicioDTO.class));

        }

        return ventasServiciosDTO;

    }

    @Override
    public VentaServicioDTO getVentaServicioById(Long id_venta) throws IdNotFoundException {

        VentaServicio ventaServicio= ventaServicioRepo.findById(id_venta).orElseThrow(() -> new IdNotFoundException("El id " + id_ventapaquete + " no se encuentra registrado"));

        var ventaSerciioDto = modelMapper.map(ventaServicio, VentaServicioDTO.class);


        return ventaSerciioDto;
    }

    @Override
    public VentaServicioDTO saveVentaServicio(VentaServicioDTO ventaServicio) throws HibernateOperationException {
        var ventaserviciosave = modelMapper.map(ventaServicio, VentaServicio.class);

        try{
            ventaserviciosave = ventaServicioRepo.save(ventaserviciosave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var ventaServicioDtoSave = modelMapper.map(ventaserviciosave , VentaServicioDTO.class);

        return ventaServicioDtoSave ;
    }
}
