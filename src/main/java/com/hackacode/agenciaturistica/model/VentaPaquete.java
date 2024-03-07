package com.hackacode.agenciaturistica.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class VentaPaquete extends Venta {

    @OneToOne
    @JoinColumn(name = "venta_paquete_codigo", referencedColumnName = "codigo_paquete")
    private PaqueteTuristico paquete;
}
