package com.hackacode.agenciaturistica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {

    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String email;
    private String celular;
    private String nacionalidad;

    private String cargo;
    private double sueldo;
}
