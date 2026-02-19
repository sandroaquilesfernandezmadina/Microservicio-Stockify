package org.stockify.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stockify.client.CategoriaClient;
import org.stockify.dto.ProductoRequest;
import org.stockify.dto.ProductoResponse;
import org.stockify.entity.Producto;
import org.stockify.mapper.ProductoMapper;
import org.stockify.repository.ProductoRepository;
import org.stockify.Service.ProductoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private  final ProductoMapper productoMapper;
    private  final CategoriaClient categoriaClient;

    @Override
    public List<ProductoResponse> findAll() {
        return productoRepository.findAll()
                .stream()
                .map(producto -> {

                    ProductoResponse response = productoMapper.toResponse(producto);

                    response.setCategoria(
                            categoriaClient.getCategoriaById(producto.getCategoriaId())
                    );

                    return response;
                })
                .toList();
    }

    @Override
    public ProductoResponse findAllById(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        ProductoResponse response = productoMapper.toResponse(producto);

        response.setCategoria(
                categoriaClient.getCategoriaById(producto.getCategoriaId())
        );

        return response;
    }

    @Override
    public ProductoResponse Save(ProductoRequest request) {

        // 🔥 Validar que la categoría exista
        categoriaClient.getCategoriaById(request.getCategoriaId());

        Producto producto = productoMapper.toEntity(request);

        Producto guardado = productoRepository.save(producto);

        return productoMapper.toResponse(guardado);
    }

    @Override
    public ProductoResponse Update(Long id, ProductoRequest request) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Validar categoría
        categoriaClient.getCategoriaById(request.getCategoriaId());

        // Actualización manual
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        producto.setCategoriaId(request.getCategoriaId());

        Producto actualizado = productoRepository.save(producto);

        return productoMapper.toResponse(actualizado);
    }

    @Override
    public void delete(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }
}
