package org.stockify.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequest {
    private String nombre;
    private Double precio;
    private Long categoriaId;
}
