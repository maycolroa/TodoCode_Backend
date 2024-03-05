package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoRepository extends JpaRepository <Pago,Long> {
}
