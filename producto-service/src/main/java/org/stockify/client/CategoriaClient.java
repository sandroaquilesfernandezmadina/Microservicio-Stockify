package org.stockify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.stockify.dto.CategoriaResponse;

@FeignClient(name = "CATEGORIA-SERVICE")
public interface CategoriaClient {

    @GetMapping("/service/categoria/{id}")
    CategoriaResponse getCategoriaById(@PathVariable("id") Long id);
}

