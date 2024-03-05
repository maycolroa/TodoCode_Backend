package com.hackacode.agenciaturistica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private TipoPago tipoPago;

    private LocalDateTime fechaPago;


}
