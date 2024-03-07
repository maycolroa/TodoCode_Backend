package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.TipoPagoDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.TipoPago;
import com.hackacode.agenciaturistica.model.TipoServicio;
import com.hackacode.agenciaturistica.repository.ITipoPagoRepository;
import com.hackacode.agenciaturistica.repository.ITipoServicioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoPagoServiceImp implements ITipoPagoService {

    @Autowired
    private ITipoPagoRepository  tipoPagoRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TipoPagoDTO> getAll() {

        var tiposBD = tipoPagoRepo.findAll();
        var tiposDTO = new ArrayList<TipoPagoDTO>();

        for (TipoPago tipoPago : tiposBD){
            tiposDTO.add(modelMapper.map(tipoPago, TipoPagoDTO.class));

        }

        return tiposDTO;

    }

    @Override
    public TipoPagoDTO getTipoPagoById(Long id_tipo) throws IdNotFoundException {

        TipoPago tipopago= tipoPagoRepo.findById(id_tipo).orElseThrow(() -> new IdNotFoundException("El id " + id_tipo + " no se encuentra registrado"));

        var tipoDto = modelMapper.map(tipopago, TipoPagoDTO.class);


        return tipoDto;
    }

    @Override
    public TipoPagoDTO saveTipoPago(TipoPagoDTO tipoPagoDto) throws HibernateOperationException {


        var tipopagosave = modelMapper.map(tipoPagoDto, TipoPago.class);

        try{
            tipopagosave = tipoPagoRepo.save(tipopagosave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var tipopagoDtoSave = modelMapper.map(tipopagosave, TipoPagoDTO.class);

        return tipopagoDtoSave;

    }
}
