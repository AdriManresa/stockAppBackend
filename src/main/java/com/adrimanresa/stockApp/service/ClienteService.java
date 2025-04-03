package com.adrimanresa.stockApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrimanresa.stockApp.model.Cliente;
import com.adrimanresa.stockApp.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepo.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepo.deleteById(id);
    }
}
