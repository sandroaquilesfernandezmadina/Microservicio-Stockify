package org.stockify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.stockify.entity.Categoria;
import org.stockify.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAll(){
        return categoriaService.Findall();
    }

    @GetMapping("/{id}")
    public Optional <Categoria> findById(@PathVariable Long id){
        return  categoriaService.FindById(id);
    }

    @PostMapping
    public  Categoria save(@RequestBody Categoria categoria){
        return categoriaService.Save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria){
    categoria.setId(id);
    return categoriaService.Update(id, categoria);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoriaService.FindById(id);
    }
}
