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
public class Pago {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_pago;

    private double montoTotal;

    @ManyToOne
    private TipoPago tipoPago;

    private LocalDateTime fechaPago;

    @OneToOne
    @JoinColumn (name = "pago_venta_num", referencedColumnName = "num_venta")
    private Venta venta;


}
