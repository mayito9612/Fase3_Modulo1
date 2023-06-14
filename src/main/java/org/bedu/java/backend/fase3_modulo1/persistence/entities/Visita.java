package org.bedu.java.backend.fase3_modulo1.persistence.entities;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "visitas")
@Entity
@NoArgsConstructor
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDateTime fechaProgramada;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String proposito;

    @Column(nullable = false)
    private String vendedor;
}
