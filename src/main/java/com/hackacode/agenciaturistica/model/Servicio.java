package com.hackacode.agenciaturistica.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Servicio {

    private Long codigo_servicio ;
    private String nombre;
    private String descripcion_breve;
    private String destino_servicio;
    private LocalDateTime fechaServicio;
    private double costo_servicio;
    private TipoServicio tipoServicio;


}
