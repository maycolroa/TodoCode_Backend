package com.hackacode.agenciaturistica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaqueteTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_paquete;
    private double costo_paquete;
    private double descuento;

    @OneToMany
    private List<Servicio> servicios;


    public double getCosto(){
        return this.costo_paquete;
    }

}
