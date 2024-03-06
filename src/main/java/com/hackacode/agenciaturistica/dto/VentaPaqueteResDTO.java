package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.Pago;
import com.hackacode.agenciaturistica.model.PaqueteTuristico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaPaqueteResDTO extends VentaAbstractDTO{
    private PaqueteTuristico paquete;

    private Pago pago;
}
