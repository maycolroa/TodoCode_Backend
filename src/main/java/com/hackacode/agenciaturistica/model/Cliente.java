package com.hackacode.agenciaturistica.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    private Long Id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String email;
    private String celular;
    private String nacionalidad;
}
