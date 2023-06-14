package org.bedu.java.backend.fase3_modulo1.persistence;

import org.bedu.java.backend.fase3_modulo1.persistence.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
}
