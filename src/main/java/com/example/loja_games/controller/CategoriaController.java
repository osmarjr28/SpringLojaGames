package com.example.loja_games.controller;

import com.example.loja_games.model.Categoria;
import com.example.loja_games.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){

        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<Categoria> getByTipo(@PathVariable String tipo) {

        return categoriaRepository.findAllByTipoContainingIgnoreCase(tipo)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());

    }
}

