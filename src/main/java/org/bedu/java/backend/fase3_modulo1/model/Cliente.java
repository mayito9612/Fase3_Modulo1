package org.bedu.java.backend.fase3_modulo1.model;


import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@Builder
public class Cliente {
    @PositiveOrZero(message = "El identificador no puede ser un numero negativo")
    private long id;

    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    @Size(min = 5, max = 30, message = "El nombre del cliente debe tener al menos {min} letras y ser menor a {max}")
    private String nombre;

    @Email
    private String correoContacto;

    @Min(value = 10, message = "Los clientes con menos de {value} empleados no son validos")
    @Max(value = 10000, message = "Los clientes con más de {value} empleados no son validos")
    private int numeroEmpleados;

    @NotBlank(message = "Se debe ingresar una direccion")
    private String direccion;


}
