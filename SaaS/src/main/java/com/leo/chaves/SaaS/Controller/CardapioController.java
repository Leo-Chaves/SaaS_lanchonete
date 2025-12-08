package com.leo.chaves.SaaS.Controller;

import com.leo.chaves.SaaS.Entity.Cardapio;
import com.leo.chaves.SaaS.Service.CardapioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
@RequiredArgsConstructor
public class CardapioController {

    private final CardapioService service;

    @GetMapping
    public ResponseEntity<List<Cardapio>> listarCardapio() {
        return ResponseEntity.ok(service.listar());
    }
}

