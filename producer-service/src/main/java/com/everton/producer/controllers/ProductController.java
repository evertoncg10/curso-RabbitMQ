package com.everton.producer.controllers;

import com.everton.producer.services.ProductService;
import com.everton.producer.services.StringService;
import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> produce(@RequestBody ProductDTO productDTO) {
        service.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }
}
