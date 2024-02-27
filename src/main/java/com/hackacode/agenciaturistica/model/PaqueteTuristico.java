package com.hackacode.agenciaturistica.model;

import jakarta.persistence.Entity;
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
    private Long codigo_paquete ;
    private double costo_paquete;
    private double descuento;
    private List<Servicio> servicios;
}
