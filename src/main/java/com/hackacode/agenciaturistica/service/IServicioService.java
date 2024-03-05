package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ServicioDTO;
import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IServicioService {


    public List<ServicioDTO> getAll();

    public ServicioDTO getServicioById(Long id_servicio) throws IdNotFoundException;

    public ServicioDTO saveServicio (ServicioDTO servicio) throws HibernateOperationException;


}
