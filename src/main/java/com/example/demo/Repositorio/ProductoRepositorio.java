package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidades.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    
}
