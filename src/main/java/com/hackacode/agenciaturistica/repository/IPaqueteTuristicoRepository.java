package com.hackacode.agenciaturistica.repository;

import com.hackacode.agenciaturistica.model.PaqueteTuristico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaqueteTuristicoRepository extends JpaRepository<PaqueteTuristico, Long> {
}
