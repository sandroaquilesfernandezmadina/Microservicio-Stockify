package org.stockify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stockify.entity.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long> {


}
