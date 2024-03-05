package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImp implements IServicioService {
    @Override
    public List<ServicioDTO> getAll() {
        return null;
    }

    @Override
    public ServicioDTO getServicioById(Long id_servicio) throws IdNotFoundException {
        return null;
    }

    @Override
    public ServicioDTO saveServicio(ServicioDTO servicio) throws HibernateOperationException {
        return null;
    }
}
