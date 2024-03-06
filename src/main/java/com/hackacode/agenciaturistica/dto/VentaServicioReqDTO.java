package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaServicioReqDTO extends VentaAbstractDTO{

    private Servicio servicio;
}
