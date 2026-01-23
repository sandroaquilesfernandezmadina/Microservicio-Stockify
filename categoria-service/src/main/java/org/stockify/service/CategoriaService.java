package org.stockify.service;

import org.stockify.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> Findall();
    Optional <Categoria> FindById (Long id);
    Categoria  Save(Categoria categoria);
    Categoria Update(Long id, Categoria categoria);
    void delete (Long id);

}
