package com.hackacode.agenciaturistica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class VentaPaquete extends Venta {
    @OneToOne
    @JoinColumn(name = "venta_paquete_codigo", referencedColumnName = "codigo_paquete")
    private PaqueteTuristico paquete;
}
