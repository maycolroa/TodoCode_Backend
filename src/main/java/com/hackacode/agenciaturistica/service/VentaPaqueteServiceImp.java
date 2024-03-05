package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.VentaPaqueteResDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.VentaPaquete;
import com.hackacode.agenciaturistica.repository.IVentaPaqueteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaPaqueteServiceImp implements IVentaPaqueteService{

    @Autowired
    private IVentaPaqueteRepository ventaPaqueteRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public List<VentaPaqueteResDTO> getAll() {
        var ventaspaquetesBD = ventaPaqueteRepo.findAll();
        var ventaspaquetesDTO = new ArrayList<VentaPaqueteResDTO>();

        for (VentaPaquete ventapaquete : ventaspaquetesBD){
            ventaspaquetesDTO.add(modelMapper.map(ventapaquete, VentaPaqueteResDTO.class));

        }

        return ventaspaquetesDTO;

    }

    @Override
    public VentaPaqueteResDTO getVentaPaqueteById(Long id_ventapaquete) throws IdNotFoundException{
        VentaPaquete ventaPaquete= ventaPaqueteRepo.findById(id_ventapaquete).orElseThrow(() -> new IdNotFoundException("El id " + id_ventapaquete + " no se encuentra registrado"));

        var ventaPaqueteDto = modelMapper.map(ventaPaquete, VentaPaqueteResDTO.class);


        return ventaPaqueteDto;
    }

    @Override
    public VentaPaqueteResDTO saveVentaPaquete (VentaPaqueteResDTO ventaPaqueteServicio) throws HibernateOperationException {
        var ventapaquetesave = modelMapper.map(ventaPaqueteServicio, VentaPaquete.class);

        try{
            ventapaquetesave = ventaPaqueteRepo.save(ventapaquetesave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var ventaPaqueteDtoSave = modelMapper.map(ventapaquetesave , VentaPaqueteResDTO.class);

        return ventaPaqueteDtoSave;
    }
}
