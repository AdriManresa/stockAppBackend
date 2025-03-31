package com.adrimanresa.stockApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.adrimanresa.stockApp.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
