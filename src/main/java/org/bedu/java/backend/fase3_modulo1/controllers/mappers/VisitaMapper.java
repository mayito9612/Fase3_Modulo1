package org.bedu.java.backend.fase3_modulo1.controllers.mappers;

import org.bedu.java.backend.fase3_modulo1.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.java.backend.fase3_modulo1.model.Visita visitaModel);

    org.bedu.java.backend.fase3_modulo1.model.Visita visitaEntityToVisitaModel(Visita visita);
}
