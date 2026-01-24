package org.stockify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stockify.Service.ProductoService;
import org.stockify.entity.Categoria;
import org.stockify.entity.Producto;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController{
    @Autowired
    private ProductoService productoService;

    @GetMapping
    private List<Producto> findAll(){
        return productoService.findAll();
    }







}
