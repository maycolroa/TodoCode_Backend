package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaqueteTuristicoDTO {

    private Long codigo_paquete ;
    private double costo_paquete;
    private double descuento;
    private List<Servicio> servicios;



}
