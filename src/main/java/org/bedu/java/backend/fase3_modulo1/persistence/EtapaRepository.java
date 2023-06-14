package org.bedu.java.backend.fase3_modulo1.persistence;

import org.bedu.java.backend.fase3_modulo1.persistence.entities.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long> {
}
