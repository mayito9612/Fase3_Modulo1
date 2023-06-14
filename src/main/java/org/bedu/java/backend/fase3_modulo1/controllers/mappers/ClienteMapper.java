package org.bedu.java.backend.fase3_modulo1.controllers.mappers;

import org.bedu.java.backend.fase3_modulo1.persistence.entities.Cliente;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(org.bedu.java.backend.fase3_modulo1.model.Cliente clienteModel);

    org.bedu.java.backend.fase3_modulo1.model.Cliente clienteEntityToClienteModel(Cliente cliente);
}