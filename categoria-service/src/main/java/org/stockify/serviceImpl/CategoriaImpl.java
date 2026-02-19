package org.stockify.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stockify.dto.CategoriaRequest;
import org.stockify.dto.CategoriaResponse;
import org.stockify.entity.Categoria;
import org.stockify.exeption.ResourceNotFoundException;
import org.stockify.mepper.CategoriaMapper;
import org.stockify.repository.CategoriaRepository;
import org.stockify.service.CategoriaService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaResponse> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaResponse FindById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
        return categoriaMapper.toResponse(categoria);
    }

    @Override
    public CategoriaResponse Save(CategoriaRequest request) {
        Categoria categoria = categoriaMapper.toEntity(request);
        Categoria guardada = categoriaRepository.save(categoria);

        return categoriaMapper.toResponse(guardada);

    }

    @Override
    public CategoriaResponse Update (Long id, CategoriaRequest request) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoría no encontrada con ID: " + id));

        categoria.setNombre(request.getNombre());

        Categoria actualizada = categoriaRepository.save(categoria);

        return categoriaMapper.toResponse(actualizada);
    }

    @Override
    public void delete(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
    categoriaRepository.deleteById(id);
    }
}
