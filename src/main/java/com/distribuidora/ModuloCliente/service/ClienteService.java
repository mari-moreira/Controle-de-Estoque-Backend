package com.distribuidora.ModuloCliente.service;

import com.distribuidora.ModuloCliente.repository.ClienteRepository;
import com.distribuidora.ModuloCliente.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // CADASTRAR
    public Cliente cadastrar(Cliente cliente) {
        return repository.save(cliente);
    }

    // LISTAR TODOS
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR
    public Optional<Cliente> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    // ATUALIZAR
    public Cliente atualizar(String cpf, Cliente dados) {
        return repository.findByCpf(cpf).map(c -> {c.setNome(dados.getNome());
            c.setTelefone(dados.getTelefone());
            c.setEndereco(dados.getEndereco());
            return repository.save(c);}).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // EXCLUIR
    public void deletar(String cpf) {
        Cliente cliente = repository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        repository.delete(cliente);
    }
}