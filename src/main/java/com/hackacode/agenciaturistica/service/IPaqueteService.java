package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PaqueteDTO;
import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IPaqueteService {


    public List<PaqueteDTO> getAll();

    public PaqueteDTO getPaqueteById(Long cod_paquete) throws IdNotFoundException;

    public ServicioDTO saveServicio (PaqueteDTO paquete) throws HibernateOperationException;

}
