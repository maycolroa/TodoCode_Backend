package com.hackacode.agenciaturistica.model;


import jakarta.persistence.*;
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
@Entity
public abstract class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long num_venta;

    protected LocalDateTime fecha_venta;

    @ManyToOne
    protected Cliente cliente;

    @ManyToOne
    protected Empleado empleado;


}
