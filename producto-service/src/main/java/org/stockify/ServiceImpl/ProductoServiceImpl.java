package org.stockify.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stockify.repository.ProductoRepository;
import org.stockify.Service.ProductoService;
import org.stockify.entity.Producto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findAllById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto Save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto Update(Long id, Producto producto) {
        Optional <Producto> optener = productoRepository.findById(id);
        if(optener.isPresent()){
          Producto prod = optener.get();
          prod.setNombre(producto.getNombre());
          prod.setPrecio(producto.getPrecio());
          prod.setCategoria(producto.getCategoria());

        return productoRepository.save(prod);
        } else{
            throw new RuntimeException("Producto no encontrada con ID: " + id);
        }
    }

    @Override
    public void delete(Long id) {
    productoRepository.deleteById(id);
    }
}
