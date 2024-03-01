package com.hackacode.agenciaturistica.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicioDTO {

    @NotNull(message = "No se permite un nombre vacio")
    @Size(min = 4, message = "Como mínimo debe tener 4 caracteres")
    private String name;
    @NotNull(message = "No se permite una descripción vacia")
    @Size(min = 4, message = "Como mínimo debe tener 4 caracteres")
    private String descripcion;
}
