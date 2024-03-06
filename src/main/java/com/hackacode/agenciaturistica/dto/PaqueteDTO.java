package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.Servicio;

import java.util.List;

public class PaqueteDTO {
    private Long codigo_paquete ;
    private double costo_paquete;
    private double descuento;
    private List<Servicio> servicios;
}
