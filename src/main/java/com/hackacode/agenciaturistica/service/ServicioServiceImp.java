package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.Servicio;
import com.hackacode.agenciaturistica.model.TipoServicio;
import com.hackacode.agenciaturistica.repository.IServicioRepository;
import com.hackacode.agenciaturistica.repository.ITipoServicioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioServiceImp implements IServicioService {

    @Autowired
    private IServicioRepository servicioRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ServicioDTO> getAll() {

        var serviciosBD = servicioRepo.findAll();
        var serviciosDTO = new ArrayList<ServicioDTO>();

        for (Servicio servicio : serviciosBD ){
            serviciosDTO.add(modelMapper.map(servicio, ServicioDTO.class));

        }

        return serviciosDTO;
    }

    @Override
    public ServicioDTO getServicioById(Long id_servicio) throws IdNotFoundException {
        Servicio servicio= servicioRepo.findById(id_servicio).orElseThrow(() -> new IdNotFoundException("El id " + id_servicio + " no se encuentra registrado"));

        var servicioDto = modelMapper.map(servicio, ServicioDTO.class);


        return servicioDto;
    }

    @Override
    public ServicioDTO saveServicio(ServicioDTO servicio) throws HibernateOperationException {
        var serviciosave = modelMapper.map(servicio, Servicio.class);

        try{
            serviciosave = servicioRepo.save(serviciosave);
        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }


        var servicioDtoSave = modelMapper.map(serviciosave, ServicioDTO.class);

        return servicioDtoSave;
    }


    @Override
    public void deleteServicioById(Long idServicio) throws IdNotFoundException {

        try {
            this.servicioRepo.deleteById(idServicio);
        } catch (Exception e) {
            throw new IdNotFoundException("El id " + idServicio + " no existe");
        }
    }

    @Override
    public ServicioDTO editServicio(Long idServicio, ServicioDTO ServicioDTONew) throws HibernateOperationException, IdNotFoundException {



        ServicioDTO ServicioBD = this.getServicioById(idServicio) ;

        // aca tendria que varidar que no exista.


        ServicioBD.setNombre(ServicioDTONew.getNombre());
        ServicioBD.setDescripcion_breve(ServicioDTONew.getDescripcion_breve());
        ServicioBD.setCosto_servicio(ServicioDTONew.getCosto_servicio() ) ;
        ServicioBD.setTipoServicio(ServicioDTONew.getTipoServicio() ) ;
        ServicioBD.setFechaServicio(ServicioDTONew.getFechaServicio() ) ;


        var serviciosave = modelMapper.map(ServicioBD, Servicio.class);
        serviciosave.setCodigo_servicio(idServicio) ;

        try{
            serviciosave = servicioRepo.save(serviciosave);


        } catch (Exception ex) {
            throw new HibernateOperationException ("Error con hibertane: " + ex.getMessage());
        }

        var serviciosaveDto= modelMapper.map( serviciosave, ServicioDTO.class);

        return serviciosaveDto;


    }
}
