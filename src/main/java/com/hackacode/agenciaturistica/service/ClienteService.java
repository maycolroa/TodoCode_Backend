package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.model.Cliente;
import com.hackacode.agenciaturistica.repository.IClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClienteDTO> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();

        ArrayList<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

        for (Cliente cliente : clientes) {
            clientesDTO.add(modelMapper.map(cliente,ClienteDTO.class));
        }

        return clientesDTO;
    }

    @Override
    public ClienteDTO getClienteById(Long idCliente) throws IdNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(
                () -> new IdNotFoundException("El id " + idCliente + " no se encuentra registrado")
        );

        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);

        return clienteDTO;
    }

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) throws HibernateOperationException {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);

        try {
            cliente = clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibertane: " + e.getMessage());
        }

        ClienteDTO clienteDtoSave = modelMapper.map(cliente, ClienteDTO.class);

        return clienteDtoSave;
    }

    @Override
    public void deleteClienteById(Long idCliente) throws IdNotFoundException {
        try {
            this.clienteRepository.deleteById(idCliente);
        } catch (Exception e) {
            throw new IdNotFoundException("El id " + idCliente + " no existe");
        }
    }
}
