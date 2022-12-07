package com.example.loja_games.controller;

import javax.validation.Valid;

import com.example.loja_games.model.Produto;
import com.example.loja_games.repository.CategoriaRepository;
import com.example.loja_games.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping
    public ResponseEntity<List<Produto>> getAll (){
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Produto> postPostagem(@Valid @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> putPostagem (@Valid @RequestBody Produto produto){
        return produtoRepository.findById((produto.getId()))
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(produtoRepository.save(produto)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<Produto> produtos = produtoRepository.findById(id);

        if(produtos.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        produtoRepository.deleteById(id);
    }


}