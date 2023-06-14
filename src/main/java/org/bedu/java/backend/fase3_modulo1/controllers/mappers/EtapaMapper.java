package org.bedu.java.backend.fase3_modulo1.controllers.mappers;

import org.bedu.java.backend.fase3_modulo1.persistence.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {
    Etapa etapaModelToEtapaEntity(org.bedu.java.backend.fase3_modulo1.model.Etapa etapaModel);

    org.bedu.java.backend.fase3_modulo1.model.Etapa etapaEntityToEtapaModel(Etapa etapa);
}
