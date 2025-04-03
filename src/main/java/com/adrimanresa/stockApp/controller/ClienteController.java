package com.adrimanresa.stockApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrimanresa.stockApp.model.Cliente;
import com.adrimanresa.stockApp.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // para poder acceder desde la app móvil
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
