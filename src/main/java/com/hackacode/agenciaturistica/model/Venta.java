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
public abstract class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long num_venta;

    protected LocalDateTime fecha_venta;

    protected Cliente cliente;

    protected Empleado empleado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "pago_venta_id", referencedColumnName = "id_pago")
    protected Pago pago;

}
