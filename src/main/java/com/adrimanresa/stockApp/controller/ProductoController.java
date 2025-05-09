package com.adrimanresa.stockApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrimanresa.stockApp.model.MovimientoStock;
import com.adrimanresa.stockApp.model.Producto;
import com.adrimanresa.stockApp.repository.MovimientoStockRepository;
import com.adrimanresa.stockApp.repository.ProductoRepository;
import com.adrimanresa.stockApp.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // para permitir peticiones desde React Native
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private MovimientoStockRepository movimientoRepo;

    @Autowired
    private ProductoRepository productoRepo;

    // ✅ Este es el endpoint correcto para GET /api/productos
    @GetMapping
    public List<Producto> listar() {
        return productoService.listarProductos();
    }

    // ✅ Usá solo uno de los dos POST (yo te dejo este)
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @GetMapping("/con-movimientos")
    public List<MovimientoStock> getAllMovimientos() {
        return movimientoRepo.findAll();
    }
}
