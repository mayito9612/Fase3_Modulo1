package org.bedu.java.backend.fase3_modulo1.persistence;


import org.bedu.java.backend.fase3_modulo1.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
