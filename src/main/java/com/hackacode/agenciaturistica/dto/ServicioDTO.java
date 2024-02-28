package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.TipoServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {

    private String nombre;
    private String descripcion_breve;
    private String destino_servicio;
    private LocalDateTime fechaServicio;
    private double costo_servicio;
    private TipoServicio tipoServicio;

}
