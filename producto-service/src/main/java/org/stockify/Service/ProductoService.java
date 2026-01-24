package org.stockify.Service;

import org.apache.juli.logging.Log;
import org.stockify.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    Optional <Producto> findAllById(Long id);
    Producto  Save(Producto producto);
    Producto Update(Long id, Producto producto);
    void delete(Long id);

}
