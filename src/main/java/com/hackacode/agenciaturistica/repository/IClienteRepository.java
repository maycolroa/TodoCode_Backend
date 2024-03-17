package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByDni(String dni);
}
