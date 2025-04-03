package com.adrimanresa.stockApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrimanresa.stockApp.model.MovimientoStock;
import com.adrimanresa.stockApp.repository.MovimientoStockRepository;
import com.adrimanresa.stockApp.service.StockService;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoStockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private MovimientoStockRepository movimientoRepo;


    @PostMapping
    public ResponseEntity<String> registrarMovimiento(@RequestBody MovimientoStock movimiento) {
        try {
            stockService.registrarMovimiento(movimiento);
            return ResponseEntity.ok("Movimiento registrado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    @GetMapping("/producto/{id}")
    public List<MovimientoStock> getMovimientosPorProducto(@PathVariable Long id) {
        return movimientoRepo.findByProductoId(id);
    }
}
