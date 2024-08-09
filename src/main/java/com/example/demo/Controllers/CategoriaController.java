package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entidades.Categoria;
import com.example.demo.Repositorio.CategoriaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;



@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @GetMapping()
    public List<Categoria> getAllCategory() {
        return categoriaRepositorio.findAll();
    }

    @PostMapping()
    public Categoria crearCategory(@RequestBody Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }
    
    @GetMapping("/{id}")
    public Categoria getCategoryById(@RequestParam int id) {
        return categoriaRepositorio.findById(id).
        orElseThrow(() -> new RuntimeException("Nose encontró el producto con id: " + id));
    }

    @PutMapping("/{id}")
    public Categoria putMethodName(@PathVariable int id, @RequestBody Categoria categoriaInfo) {
        Categoria categoria = categoriaRepositorio.findById(id).
        orElseThrow(() -> new RuntimeException("Nose encontró el producto con id: " + id));

        categoria.setNombre(categoriaInfo.getNombre());
        return categoriaRepositorio.save(categoria);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable int id) {
        Categoria categoria = categoriaRepositorio.findById(id).
        orElseThrow(() -> new RuntimeException("Nose encontró la categoría con id: " + id));

        categoriaRepositorio.delete(categoria);
        return "La categoría de id: " + id + " fue eliminado correctamente";
    }

    
    
    

}
