package com.hackacode.agenciaturistica.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long num_venta;

    protected LocalDateTime fecha_venta;

    protected Cliente cliente;

    protected Empleado empleado;

    protected Pago pago;

}