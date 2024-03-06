package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.Pago;
import com.hackacode.agenciaturistica.model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaServicioResDTO extends VentaAbstractDTO{

    private Servicio servicio;
    private Pago pago;
}
