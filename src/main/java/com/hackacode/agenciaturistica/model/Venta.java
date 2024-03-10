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
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long num_venta;

    protected LocalDateTime fecha_venta;

    @ManyToOne
    protected Cliente cliente;

    @ManyToOne
    protected Empleado empleado;


}
