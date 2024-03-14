package com.hackacode.agenciaturistica.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_servicio ;
    private String nombre;
    private String descripcion_breve;
    private String destino_servicio;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaServicio;
    private double costo_servicio;
    @ManyToOne
    @JoinColumn (name = "tipo_servicio_id", referencedColumnName = "id_tipo")
    private TipoServicio tipoServicio;


    public double getCosto(){
        return this.costo_servicio;
    }

}
