package com.hackacode.agenciaturistica.dto;

import com.hackacode.agenciaturistica.model.PaqueteTuristico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaPaqueteReqDTO extends VentaAbstractDTO {

    private PaqueteTuristico paquete;

}
