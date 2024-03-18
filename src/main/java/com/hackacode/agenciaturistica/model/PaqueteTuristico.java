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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicio> servicios;

    private double costoTotal=0.0;
    private double descuentoActual;
    private double precioConDescuento;


    public void calcularCostoyDescuento(){

        descuentoActual = descuentoActual * descuento ;
        servicios.forEach(serv -> {

            costoTotal = costoTotal + serv.getCosto();
        });

        precioConDescuento = costoTotal - descuentoActual ;

        this.setCosto_paquete(precioConDescuento);

    }


    public double getCosto(){


        return this.costo_paquete;

    }


}
