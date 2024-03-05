package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.VentaServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaServicioRepository extends JpaRepository<VentaServicio,Long> {
}
