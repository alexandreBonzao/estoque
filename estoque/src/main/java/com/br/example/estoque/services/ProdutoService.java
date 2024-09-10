package com.br.example.estoque.services;

import com.br.example.estoque.model.Produto;
import com.br.example.estoque.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
}
