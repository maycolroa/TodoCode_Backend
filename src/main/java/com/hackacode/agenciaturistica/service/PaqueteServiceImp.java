package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PaqueteDTO;
import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public class PaqueteServiceImp implements IPaqueteService{

    @Override
    public List<PaqueteDTO> getAll() {
        return null;
    }

    @Override
    public PaqueteDTO getPaqueteById(Long cod_paquete) throws IdNotFoundException {
        return null;
    }

    @Override
    public ServicioDTO saveServicio(PaqueteDTO paquete) throws HibernateOperationException {
        return null;
    }
}
