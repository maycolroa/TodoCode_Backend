package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPagoRepository extends JpaRepository  <TipoPago, Long>{
}
