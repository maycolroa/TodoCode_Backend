package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.VentaPaquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaPaqueteRepository extends JpaRepository<VentaPaquete,Long> {
}
