package com.hackacode.agenciaturistica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_paquete ;
    private double costo_paquete;
    private double descuento;
    private List<Servicio> servicios;


    public double getCosto(){
        return this.costo_paquete;
    }

}
