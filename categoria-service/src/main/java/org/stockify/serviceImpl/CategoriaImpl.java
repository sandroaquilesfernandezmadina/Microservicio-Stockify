package org.stockify.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stockify.entity.Categoria;
import org.stockify.repository.CategoriaRepository;
import org.stockify.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> Findall() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> FindById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria Save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria Update(Long id, Categoria categoria) {
        Optional<Categoria> optener = categoriaRepository.findById(id);
        if(optener.isPresent()){
            Categoria cat = optener.get();
            cat.setNombre(categoria.getNombre());
            return categoriaRepository.save(cat);

        }else{
            throw new RuntimeException("Categoría no encontrada con ID: " + id);
        }
    }

    @Override
    public void delete(Long id) {
    categoriaRepository.findById(id);
    }
}
