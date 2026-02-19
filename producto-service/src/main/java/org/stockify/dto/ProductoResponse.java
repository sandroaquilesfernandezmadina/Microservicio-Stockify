package org.stockify.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoResponse {
    private Long id;
    private String nombre;
    private Double precio;
    private Long categoriaId;
    private CategoriaResponse categoria;

}
