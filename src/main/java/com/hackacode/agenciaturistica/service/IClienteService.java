package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;

import java.util.List;

public interface IClienteService {

    public List<ClienteDTO> getAllClientes();

    public ClienteDTO getClienteById(Long idCliente) throws IdNotFoundException;

    public ClienteDTO saveCliente(ClienteDTO cliente) throws HibernateOperationException;

    public ClienteDTO editCliente(Long idCliente, ClienteDTO cliente) throws IdNotFoundException, HibernateOperationException;

    public void deleteClienteById(Long idCliente) throws IdNotFoundException;
}
