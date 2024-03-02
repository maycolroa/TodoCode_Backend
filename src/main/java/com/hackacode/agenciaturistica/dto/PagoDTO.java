package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.TipoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {

    private double montoTotal;

    private TipoPago tipopago;
}
