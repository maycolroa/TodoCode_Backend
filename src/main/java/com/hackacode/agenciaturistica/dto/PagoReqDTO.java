package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.TipoPago;
import com.hackacode.agenciaturistica.model.Venta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagoReqDTO {


    private TipoPago tipopago;

    private LocalDateTime fechaPago;

    private Venta venta;
}
