package org.stockify.mepper;

import org.springframework.stereotype.Component;
import org.stockify.dto.CategoriaRequest;
import org.stockify.dto.CategoriaResponse;
import org.stockify.entity.Categoria;

@Component
public class CategoriaMapper {

    //ingresar datos de parte del cliente
    public Categoria toEntity(CategoriaRequest request) {
        Categoria categoria = new Categoria();
        categoria.setNombre(request.getNombre());
        return categoria;
    }

    //devolver datos de parte del servidor
    public CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNombre()
        );
    }
}
