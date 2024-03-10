package com.hackacode.agenciaturistica.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class VentaServicio extends Venta{

    @OneToOne
    @JoinColumn(name = "venta_codigo_servicio", referencedColumnName = "codigo_servicio")
    private  Servicio servicio;
}
