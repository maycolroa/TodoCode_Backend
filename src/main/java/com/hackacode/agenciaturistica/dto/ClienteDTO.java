package com.hackacode.agenciaturistica.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private LocalDate fecha_nac;
    private String nacionalidad;
    private String celular;
    @Email
    private String email;
}
