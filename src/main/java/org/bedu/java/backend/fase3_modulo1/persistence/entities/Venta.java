package org.bedu.java.backend.fase3_modulo1.persistence.entities;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "ventas")
@Entity
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ventaId;

    private float monto;

    @OneToMany
    private List<Producto> productos;

    @ManyToOne
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
}
