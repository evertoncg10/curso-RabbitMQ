package com.everton.producer.controllers;

import com.everton.producer.services.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produces")
@RequiredArgsConstructor
public class StringController {

    private final StringService service;

    @GetMapping
    public ResponseEntity<String> produce(@RequestParam String message) {
        service.produce(message);
        return ResponseEntity.ok().body("Mensagem enviada com sucesso");
    }
}
