package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.TipoServicioDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.exception.TipoServicioExistException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITipoServicio {

    public List<TipoServicioDTO> getAll();

    public TipoServicioDTO getTipoServicioById(Long id_tipo) throws IdNotFoundException;

    public TipoServicioDTO saveTipoServicio(TipoServicioDTO tipoServicio) throws HibernateOperationException, TipoServicioExistException;


    public TipoServicioDTO editTipoServicio(@PathVariable Long idTipoServicio, @RequestBody TipoServicioDTO tipoServicioDTO) throws HibernateOperationException, IdNotFoundException;

    public void deleteTipoServicioById(@PathVariable Long idTipoServicio) throws IdNotFoundException;


}
