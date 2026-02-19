package org.stockify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stockify.dto.CategoriaRequest;
import org.stockify.dto.CategoriaResponse;
import org.stockify.entity.Categoria;
import org.stockify.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service/categoria")
@RequiredArgsConstructor
public class CategoriaController {

 private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> findAll(){
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.FindById(id));
    }

    @PostMapping
    public  ResponseEntity<CategoriaResponse> save(@RequestBody CategoriaRequest request){
        return ResponseEntity.ok(categoriaService.Save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> update(@PathVariable Long id, @RequestBody CategoriaRequest request){
    return ResponseEntity.ok(categoriaService.Update(id, request));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
         categoriaService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
