package com.hackacode.agenciaturistica.service;


import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.TipoServicio;
import com.hackacode.agenciaturistica.repository.ITipoServicioRepository;
import jakarta.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoServicioImp implements ITipoServicio {

    @Autowired
    private ITipoServicioRepository tipoServicioRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TipoServicioDTO> getAll() {

        var tiposBD = tipoServicioRepo.findAll();
        var tiposDTO = new ArrayList<TipoServicioDTO>();

        for (TipoServicio tipoServicio : tiposBD){
            tiposDTO.add(modelMapper.map(tipoServicio, TipoServicioDTO.class));

        }

        return tiposDTO;

    }

    @Override
    public TipoServicioDTO getTipoServicioById(Long id_tipo) throws IdNotFoundException {
        TipoServicio tiposerv= tipoServicioRepo.findById(id_tipo).orElseThrow(() -> new IdNotFoundException("El id " + id_tipo + " no se encuentra registrado"));

        var tipoDto = modelMapper.map(tiposerv, TipoServicioDTO.class);


        return tipoDto;
    }

    @Override
    public TipoServicioDTO saveTipoServicio(TipoServicioDTO tipoServicio) throws HibernateOperationException {

        var tiposerviciosave = modelMapper.map(tipoServicio, TipoServicio.class);

        try{
            tiposerviciosave = tipoServicioRepo.save(tiposerviciosave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var tiposervicioDtoSave = modelMapper.map(tiposerviciosave, TipoServicioDTO.class);

        return tiposervicioDtoSave;
    }

    @Override
    public TipoServicioDTO editTipoServicio(Long idTipoServicio, TipoServicioDTO tipoServicioDTONew) throws HibernateOperationException, IdNotFoundException {

        TipoServicioDTO tipoServiciBD = this.getTipoServicioById(idTipoServicio) ;

        // aca tendria que varidar que no exista.


        tipoServiciBD.setName(tipoServicioDTONew.getName()) ;
        tipoServiciBD.setDescripcion(tipoServicioDTONew.getDescripcion()) ;

        var tiposerviciosave = modelMapper.map(tipoServiciBD, TipoServicio.class);
        tiposerviciosave.setId_tipo(idTipoServicio);

        try{
            tiposerviciosave = tipoServicioRepo.save(tiposerviciosave);


        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }

        var tiposerviciosaveDto= modelMapper.map( tiposerviciosave, TipoServicioDTO.class);

        return tiposerviciosaveDto;
    }

    @Override
    public void deleteTipoServicioById(Long idTipoServicio) throws IdNotFoundException {

        try {
            this.tipoServicioRepo.deleteById(idTipoServicio);
        } catch (Exception e) {
            throw new IdNotFoundException("El id " + idTipoServicio + " no existe");
        }
    }
}
