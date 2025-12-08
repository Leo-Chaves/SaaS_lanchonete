package com.leo.chaves.SaaS.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cardapio")
@Data
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
}
