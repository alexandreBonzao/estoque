package com.br.example.estoque.controllers;

import com.br.example.estoque.model.Categoria;
import com.br.example.estoque.model.Produto;
import com.br.example.estoque.repositories.CategoriaRepository;
import com.br.example.estoque.repositories.ProdutoRepository;
import com.br.example.estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping()
    public List<Produto> ListarTodosProduto()   {
        return produtoRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? ResponseEntity.ok(produto.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
        Produto produtoSalva = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalva);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) { produtoRepository.deleteById(id);}

}
