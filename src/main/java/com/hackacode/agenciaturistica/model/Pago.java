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

    @OneToOne
    @JoinColumn(name = "tippo_pago_id", referencedColumnName = "Id")

    private TipoPago tipoPago;

    private LocalDateTime fechaPago;


}
