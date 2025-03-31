package com.adrimanresa.stockApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrimanresa.stockApp.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
