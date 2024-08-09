package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entidades.Producto;
import com.example.demo.Repositorio.ProductoRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepositorio productoRepositorio;


    @GetMapping
    public List<Producto> getAllProductos(/*@RequestParam String param*/) {
        return productoRepositorio.findAll();
    }

    @PostMapping //crear
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepositorio.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable int id) {
        return productoRepositorio.findById(id).
        orElseThrow(() -> new RuntimeException("Nose encontró el producto con id: " + id));
    }
    
    @PutMapping("/{id}") //actualizar
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto productodetalle) {
        Producto producto = productoRepositorio.findById(id).
        orElseThrow(() -> new RuntimeException("Nose encontró el producto con id: " + id));
        
        producto.setNombre(productodetalle.getNombre());
        producto.setPrecio(productodetalle.getPrecio());
        producto.setCategoria(productodetalle.getCategoria());
        return productoRepositorio.save(producto);
    }

    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable int id) {
        Producto producto = productoRepositorio.findById(id).
        orElseThrow(() -> new RuntimeException("Nose encontró el producto con id: " + id));

        productoRepositorio.delete(producto);
        return "El producto de id: " + id + " fue eliminado correctamente";
    }
    
}
