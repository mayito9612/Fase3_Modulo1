package org.bedu.java.backend.fase3_modulo1.controllers.mappers;

import org.bedu.java.backend.fase3_modulo1.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(org.bedu.java.backend.fase3_modulo1.model.Venta ventaModel);

    org.bedu.java.backend.fase3_modulo1.model.Venta ventaEntityToVentaModel(Venta venta);
}