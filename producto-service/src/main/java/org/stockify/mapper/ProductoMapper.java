package org.stockify.mapper;
import org.springframework.stereotype.Component;
import org.stockify.dto.ProductoRequest;
import org.stockify.dto.ProductoResponse;
import org.stockify.entity.Producto;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequest request){
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        producto.setCategoriaId(request.getCategoriaId());

        return producto;
    }

    public ProductoResponse toResponse(Producto producto){
        ProductoResponse response = new ProductoResponse();
        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setPrecio(producto.getPrecio());
        response.setCategoriaId(producto.getCategoriaId());

        return response;
    }


}
