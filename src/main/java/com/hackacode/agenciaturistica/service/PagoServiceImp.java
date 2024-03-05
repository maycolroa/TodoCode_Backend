package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PagoDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.Pago;
import com.hackacode.agenciaturistica.model.TipoServicio;
import com.hackacode.agenciaturistica.repository.IPagoRepository;
import com.hackacode.agenciaturistica.repository.ITipoServicioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PagoServiceImp implements IPagoService{

    @Autowired
    private IPagoRepository pagoRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<PagoDTO> getAll() {
        var pagosBD = pagoRepo.findAll();
        var pagosDTO = new ArrayList<PagoDTO>();

        for (Pago pago : pagosBD){
            pagosDTO.add(modelMapper.map(pago, PagoDTO.class));

        }

        return pagosDTO;
    }

    @Override
    public PagoDTO getPagoById(Long id_pago) throws IdNotFoundException {
        Pago pago= pagoRepo.findById(id_pago).orElseThrow(() -> new IdNotFoundException("El id " + id_pago + " no se encuentra registrado"));

        var pagoDto = modelMapper.map(pago, PagoDTO.class);


        return pagoDto;
    }

    @Override
    public PagoDTO savePago(PagoDTO pagoDto) throws HibernateOperationException {


        var pagosave = modelMapper.map(pagoDto, Pago.class);

        try{
            pagosave = pagoRepo.save(pagosave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var pagoDtoSave = modelMapper.map(pagosave, PagoDTO.class);

        return pagoDtoSave;

    }
}
