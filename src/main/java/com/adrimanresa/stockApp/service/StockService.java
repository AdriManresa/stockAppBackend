package com.adrimanresa.stockApp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrimanresa.stockApp.model.MovimientoStock;
import com.adrimanresa.stockApp.model.Producto;
import com.adrimanresa.stockApp.repository.MovimientoStockRepository;
import com.adrimanresa.stockApp.repository.ProductoRepository;

@Service
public class StockService {

    @Autowired
    private MovimientoStockRepository movimientoRepo;

    @Autowired
    private ProductoRepository productoRepo;

    public void registrarMovimiento(MovimientoStock movimiento) {
        Producto producto = movimiento.getProducto();

        // 1. Validar que exista el producto
        Producto productoEnBD = productoRepo.findById(producto.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // 2. Validar cantidad no cero
        if (movimiento.getCantidad() == 0) {
            throw new RuntimeException("La cantidad del movimiento no puede ser cero");
        }

        // 3. Validar stock suficiente si es egreso (cantidad negativa)
        int nuevoStock = productoEnBD.getStockActual() + movimiento.getCantidad();

        if (nuevoStock < 0) {
            throw new RuntimeException("No hay suficiente stock disponible");
        }
        
        productoEnBD.setStockActual(nuevoStock);
        productoRepo.save(productoEnBD);

        // Guardamos el movimiento con la fecha actual
        movimiento.setFecha(LocalDateTime.now());
        movimientoRepo.save(movimiento);
    }

}
