package com.adrimanresa.stockApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los campos
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;
    private String direccion;
}