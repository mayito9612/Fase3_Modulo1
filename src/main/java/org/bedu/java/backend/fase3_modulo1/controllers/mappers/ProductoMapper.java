package org.bedu.java.backend.fase3_modulo1.controllers.mappers;

import org.bedu.java.backend.fase3_modulo1.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(org.bedu.java.backend.fase3_modulo1.model.Producto productoModel);

    org.bedu.java.backend.fase3_modulo1.model.Producto productoEntityToProductoModel(Producto producto);
}
