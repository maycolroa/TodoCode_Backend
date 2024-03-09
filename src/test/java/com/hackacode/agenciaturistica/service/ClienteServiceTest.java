package com.hackacode.agenciaturistica.service;

import com.hackacode.agenciaturistica.dto.ClienteDTO;
import com.hackacode.agenciaturistica.exception.HibernateOperationException;
import com.hackacode.agenciaturistica.model.Cliente;
import com.hackacode.agenciaturistica.repository.IClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private IClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private ModelMapper modelMapper;

    @Test
    public void test1() throws HibernateOperationException {
        modelMapper = new ModelMapper();

        ClienteDTO cliente1 = new ClienteDTO(1L, "Juan", "Perez", "Encino #22",
                "JUPE22", LocalDate.of(1990, 5, 15), "Mexicana",
                "123456789", "juan@example.com");

        Mockito.when(clienteRepository.save(modelMapper.map(cliente1, Cliente.class)))
                .thenReturn(modelMapper.map(cliente1, Cliente.class));

        ClienteDTO cliente2 = new ClienteDTO(1L, "Juan", "Perez", "Encino #22",
                "JUPE22", LocalDate.of(1990, 5, 15), "Mexicana",
                "123456789", "juan@example.com");

        final ClienteDTO nuevoCliente = clienteService.saveCliente(cliente2);
        Assertions.assertEquals(cliente1, nuevoCliente);
    }
}
