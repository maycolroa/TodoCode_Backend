package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.dto.VentaPaqueteDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.TipoServicio;
import com.hackacode.agenciaturistica.model.VentaPaquete;
import com.hackacode.agenciaturistica.repository.IVentaPaqueteRepository;
import com.hackacode.agenciaturistica.repository.IVentaServicioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class VentaPaqueteServiceImp implements IVentaPaqueteService{

    @Autowired
    private IVentaPaqueteRepository ventaPaqueteRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public List<VentaPaqueteDTO> getAll() {
        var ventaspaquetesBD = ventaPaqueteRepo.findAll();
        var ventaspaquetesDTO = new ArrayList<VentaPaqueteDTO>();

        for (VentaPaquete ventapaquete : ventaspaquetesBD){
            ventaspaquetesDTO.add(modelMapper.map(ventapaquete, VentaPaqueteDTO.class));

        }

        return ventaspaquetesDTO;

    }

    @Override
    public VentaPaqueteDTO getVentaPaqueteById(Long id_ventapaquete) throws IdNotFoundException{
        VentaPaquete ventaPaquete= ventaPaqueteRepo.findById(id_ventapaquete).orElseThrow(() -> new IdNotFoundException("El id " + id_ventapaquete + " no se encuentra registrado"));

        var ventaPaqueteDto = modelMapper.map(ventaPaquete, VentaPaqueteDTO.class);


        return ventaPaqueteDto;
    }

    @Override
    public VentaPaqueteDTO saveVentaPaquete (VentaPaqueteDTO ventaPaqueteServicio) throws HibernateOperationException {
        var ventapaquetesave = modelMapper.map(ventaPaqueteServicio, VentaPaquete.class);

        try{
            ventapaquetesave = ventaPaqueteRepo.save(ventapaquetesave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var ventaPaqueteDtoSave = modelMapper.map(ventapaquetesave , VentaPaqueteDTO.class);

        return ventaPaqueteDtoSave;
    }
}
