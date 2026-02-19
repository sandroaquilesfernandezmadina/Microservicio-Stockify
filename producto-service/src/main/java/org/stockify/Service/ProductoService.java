package org.stockify.Service;

import org.stockify.dto.ProductoRequest;
import org.stockify.dto.ProductoResponse;
import org.stockify.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoResponse> findAll();
    ProductoResponse findAllById(Long id);
    ProductoResponse  Save(ProductoRequest request);
    ProductoResponse Update(Long id, ProductoRequest request);
    void delete(Long id);


}
