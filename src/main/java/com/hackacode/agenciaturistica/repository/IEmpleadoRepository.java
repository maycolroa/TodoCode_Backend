package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {
}
