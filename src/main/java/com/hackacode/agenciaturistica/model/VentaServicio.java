package com.hackacode.agenciaturistica.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VentaServicio extends Venta{

    @OneToOne
    @JoinColumn(name = "venta_codigo_servicio", referencedColumnName = "codigo_servicio")
    private  Servicio servicio;
}
