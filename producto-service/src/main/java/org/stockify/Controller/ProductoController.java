package org.stockify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.stockify.Service.ProductoService;
import org.stockify.entity.Categoria;
import org.stockify.entity.Producto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController{
    @Autowired
    private ProductoService productoService;

    @GetMapping
    private List<Producto> findAll(){
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Producto> findById(@PathVariable Long id){
        return productoService.findAllById(id);
    }
    @PostMapping
    private Producto Save(@RequestBody Producto producto){
        return  productoService.Save(producto);
    }
    @PutMapping("/{id}")
    private Producto Update(@PathVariable Long id, @RequestBody Producto producto){
        producto.setId(id);
        return productoService.Update(id , producto);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id){
        productoService.delete(id);
    }
}
