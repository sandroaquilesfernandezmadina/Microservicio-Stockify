package org.stockify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CategoriaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoriaServiceApplication.class, args);
    }
}
