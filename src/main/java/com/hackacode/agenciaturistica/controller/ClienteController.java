package com.hackacode.agenciaturistica.controller;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.exception.ClienteExistException;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.exception.IdNotFoundException;
import com.hackacode.agenciaturistica.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<ClienteDTO> getAllClientes(){
        return clienteService.getAllClientes();
    }

    @GetMapping("/{idCliente}")
    public ClienteDTO getClienteById(@PathVariable Long idCliente) throws IdNotFoundException {
        return clienteService.getClienteById(idCliente);
    }

    @PostMapping("/save")
    public ClienteDTO saveCliente(@Valid @RequestBody ClienteDTO clienteDTO) throws HibernateOperationException ,ClienteExistException{
        return clienteService.saveCliente(clienteDTO);
    }

    @PutMapping("/{idCliente}")
    public ClienteDTO editCliente(@PathVariable Long idCliente, @RequestBody ClienteDTO clienteDTO) throws HibernateOperationException, IdNotFoundException, ClienteExistException {
        return clienteService.editCliente(idCliente, clienteDTO);
    }

    @DeleteMapping("/{idCliente}")
    public void deleteClienteById(@PathVariable Long idCliente) throws IdNotFoundException {
        this.clienteService.deleteClienteById(idCliente);
    }
}
