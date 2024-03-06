package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.TipoServicio;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServicioDTO {

    private String nombre;
    private String descripcion_breve;
    private String destino_servicio;
    private LocalDateTime fechaServicio;
    private double costo_servicio;
    private TipoServicio tipoServicio;

}
