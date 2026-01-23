package org.stockify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stockify.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
}

