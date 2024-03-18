package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.exception.ClienteExistException;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.exception.TipoServicioExistException;
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

    public ClienteService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<ClienteDTO>getAllClientes() {
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
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) throws HibernateOperationException,ClienteExistException {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);


        if (clienteRepository.existsByDni(clienteDTO.getDni())) {
            throw new ClienteExistException("Ya se encuentra el cliente : " + clienteDTO.getDni());
        }



        try {
            cliente = clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new HibernateOperationException("Error con hibertane: " + e.getMessage());
        }

        ClienteDTO clienteDTOSave = modelMapper.map(cliente, ClienteDTO.class);

        return clienteDTOSave;
    }

    public ClienteDTO editCliente(Long idCliente, ClienteDTO clienteDTORecivido) throws IdNotFoundException, HibernateOperationException , ClienteExistException {

        if (clienteRepository.existsByDni(clienteDTORecivido.getDni())) {
            throw new ClienteExistException("Ya se encuentra el cliente : " + clienteDTORecivido.getDni());
        }



        ClienteDTO clienteDTO = this.getClienteById(idCliente);

        clienteDTO.setNombre(clienteDTORecivido.getNombre());
        clienteDTO.setApellido(clienteDTORecivido.getApellido());
        clienteDTO.setDireccion(clienteDTORecivido.getDireccion());
        clienteDTO.setDni(clienteDTORecivido.getDni());
        clienteDTO.setFecha_nac(clienteDTORecivido.getFecha_nac());
        clienteDTO.setNacionalidad(clienteDTORecivido.getNacionalidad());
        clienteDTO.setCelular(clienteDTORecivido.getCelular());
        clienteDTO.setEmail(clienteDTORecivido.getEmail());


        Cliente cliente  = modelMapper.map(clienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);

        ClienteDTO clienteDTODevuelto = modelMapper.map(cliente, ClienteDTO.class);

        return clienteDTODevuelto;
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
