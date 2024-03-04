package com.hackacode.agenciaturistica.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long Id;

    @NotNull(message = "No se permite un nombre vacio")
    @Size(min = 4, message = "Como mínimo debe tener 4 caracteres")
    private String nombre;

    @NotNull(message = "No se permite un Apellido vacio")
    @Size(min = 4, message = "Como mínimo debe tener 4 caracteres")
    private String apellido;
    private String direccion;
    private String dni;
    private Date fecha_nac;
    private String nacionalidad;
    private String celular;
    @Email
    private String email;
}
