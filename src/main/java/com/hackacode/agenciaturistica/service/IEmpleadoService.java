package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.EmpleadoDTO;
import com.hackacode.agenciaturistica.exception.EmpleadoExistException;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IEmpleadoService {

    public List<EmpleadoDTO> getAllEmpleados();

    public EmpleadoDTO getEmpleadoById(Long idEmpleado) throws IdNotFoundException;

    public EmpleadoDTO saveEmpleado(EmpleadoDTO empleado) throws HibernateOperationException,EmpleadoExistException;

    public EmpleadoDTO editEmpleado(Long idEmpleado, EmpleadoDTO empleadoDTORecivido) throws IdNotFoundException, HibernateOperationException, EmpleadoExistException;

    public void deleteEmpleadoById(Long idEmpleado) throws IdNotFoundException;
}
