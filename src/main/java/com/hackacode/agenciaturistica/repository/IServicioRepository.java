package com.hackacode.agenciaturistica.repository;


import com.hackacode.agenciaturistica.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio,Long> {
}
