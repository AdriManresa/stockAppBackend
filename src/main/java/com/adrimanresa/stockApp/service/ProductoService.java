package com.adrimanresa.stockApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrimanresa.stockApp.model.Producto;
import com.adrimanresa.stockApp.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepo;

    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    public Producto crearProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        producto.setId(id);
        return productoRepo.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepo.deleteById(id);
    }

    public Producto obtenerPorId(Long id) {
        return productoRepo.findById(id).orElse(null);
    }
}
