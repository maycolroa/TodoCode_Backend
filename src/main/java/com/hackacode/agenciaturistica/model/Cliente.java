package com.hackacode.agenciaturistica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private LocalDate fecha_nac;
    private String nacionalidad;
    private String celular;
    private String email;

}
