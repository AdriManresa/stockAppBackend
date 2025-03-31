package com.adrimanresa.stockApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;
    @Email(message = "El email no es válido")
    private String email;
    private String direccion;
}