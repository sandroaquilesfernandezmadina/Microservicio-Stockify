package org.stockify.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.stockify.Service.ProductoService;
import org.stockify.dto.ProductoRequest;
import org.stockify.dto.ProductoResponse;
import org.stockify.entity.Producto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController{

    private final ProductoService productoService;

    @GetMapping
    private List<ProductoResponse> findAll(){
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    private ProductoResponse findById(@PathVariable Long id){
        return productoService.findAllById(id);
    }
    @PostMapping
    private ProductoResponse Save(@RequestBody ProductoRequest request){
        return  productoService.Save(request);
    }
    @PutMapping("/{id}")
    private ProductoResponse Update(@PathVariable Long id, @RequestBody ProductoRequest request){
        return productoService.Update(id , request);
    }

    @DeleteMapping("/{id}")
    public void DeleteById(@PathVariable Long id){
        productoService.delete(id);
    }
}
