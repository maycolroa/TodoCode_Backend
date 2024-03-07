package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.PaqueteTuristicoDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IPaqueteTuristicoService {


    public List<PaqueteTuristicoDTO> getAllPaquetesTuristicos();

    public PaqueteTuristicoDTO getPaqueteTuristicoById(Long codigoPaquete) throws IdNotFoundException;

    public PaqueteTuristicoDTO savePaqueteTuristico(PaqueteTuristicoDTO paqueteTuristicoDTO) throws HibernateOperationException;

    public PaqueteTuristicoDTO editPaqueteTuristico(Long codigoPaquete, PaqueteTuristicoDTO paqueteTuristicoDTORecivido) throws IdNotFoundException, HibernateOperationException;

    public void deletePaqueteTuristicoById(Long codigoPaquete) throws IdNotFoundException;
}
