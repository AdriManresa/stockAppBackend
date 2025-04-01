package com.adrimanresa.stockApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrimanresa.stockApp.model.MovimientoStock;

public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {
    List<MovimientoStock> findByProductoId(Long productoId);
}
