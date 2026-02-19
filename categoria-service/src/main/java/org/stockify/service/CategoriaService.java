package org.stockify.service;

import org.stockify.dto.CategoriaRequest;
import org.stockify.dto.CategoriaResponse;
import org.stockify.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaResponse> findAll();
    CategoriaResponse FindById (Long id);
    CategoriaResponse  Save(CategoriaRequest request);
    CategoriaResponse Update(Long id, CategoriaRequest request);
    void delete (Long id);

}
