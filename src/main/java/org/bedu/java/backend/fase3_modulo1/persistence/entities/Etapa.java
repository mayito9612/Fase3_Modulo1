package org.bedu.java.backend.fase3_modulo1.persistence.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Table(name = "etapas")
@Entity
@NoArgsConstructor
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etapaId;

    private String nombre;

    @Column(unique = true, nullable = false)
    private Integer orden;
}
