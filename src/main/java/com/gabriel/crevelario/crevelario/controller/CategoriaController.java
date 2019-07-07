package com.gabriel.crevelario.crevelario.controller;

import com.gabriel.crevelario.crevelario.models.Categoria;

import com.gabriel.crevelario.crevelario.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {


    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Categoria getById(@PathVariable long id) {
        return categoriaRepository.getById(id);
    }

}
