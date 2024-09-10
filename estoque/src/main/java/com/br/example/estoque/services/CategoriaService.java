package com.br.example.estoque.services;

import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class    CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria salvar (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
