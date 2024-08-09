package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
    
}
