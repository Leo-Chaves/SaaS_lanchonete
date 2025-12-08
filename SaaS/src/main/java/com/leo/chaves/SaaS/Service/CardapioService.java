package com.leo.chaves.SaaS.Service;

import com.leo.chaves.SaaS.Entity.Cardapio;
import com.leo.chaves.SaaS.Repository.CardapioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardapioService {

    private final CardapioRepository repository;

    public List<Cardapio> listar() {
        return repository.findAll();
    }
}
