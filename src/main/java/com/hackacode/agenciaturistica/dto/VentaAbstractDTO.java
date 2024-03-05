package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.Cliente;
import com.hackacode.agenciaturistica.model.Empleado;
import com.hackacode.agenciaturistica.model.Pago;
import com.hackacode.agenciaturistica.model.TipoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaAbstractDTO {

    protected LocalDateTime fecha_venta;

    protected Cliente cliente;

    protected Empleado empleado;

    protected TipoPago tipoPago;

}
