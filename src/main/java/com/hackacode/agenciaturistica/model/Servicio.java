package com.hackacode.agenciaturistica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_servicio;
    private String nombre;
    private String descripcion_breve;
    private String destino_servicio;
    private LocalDate fechaServicio;
    private double costo_servicio;
    @OneToOne
    @JoinColumn (name = "tipo_servicio_id", referencedColumnName = "id_tipo")
    private TipoServicio tipoServicio;


    public double getCosto(){
        return this.costo_servicio;
    }

}
