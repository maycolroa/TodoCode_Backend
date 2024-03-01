package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoServicioRepository extends JpaRepository<TipoServicio, Long> {
}
