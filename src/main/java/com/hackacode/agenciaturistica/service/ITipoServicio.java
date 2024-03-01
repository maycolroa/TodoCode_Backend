package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface ITipoServicio {

    public List<TipoServicioDTO> getAll();

    public TipoServicioDTO getTipoServicioById(Long id_tipo) throws IdNotFoundException;

    public TipoServicioDTO saveTipoSercicio (TipoServicioDTO tipoServicio) throws HibernateOperationException;

}
