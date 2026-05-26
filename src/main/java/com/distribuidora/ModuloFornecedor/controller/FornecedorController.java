package com.distribuidora.ModuloFornecedor.controller;

import com.distribuidora.ModuloFornecedor.entity.Fornecedor;
import com.distribuidora.ModuloFornecedor.service.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@CrossOrigin(origins = "*")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    // CADASTRAR
    @PostMapping
    public Fornecedor cadastrar(@RequestBody Fornecedor fornecedor) {
        return service.cadastrar(fornecedor);
    }

    // LISTAR TODOS
    @GetMapping
    public List<Fornecedor> listar() {
        return service.listarTodos();
    }

    // BUSCAR
    @GetMapping("/cnpj/{cnpj}")
    public Fornecedor buscarPorCnpj(@PathVariable String cnpj) {
        return service.buscarPorCnpj(cnpj).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    // ATUALIZAR
    @PutMapping("/cnpj/{cnpj}")
    public Fornecedor atualizar(@PathVariable String cnpj, @RequestBody Fornecedor fornecedor) {
        return service.atualizar(cnpj, fornecedor);
    }

    // EXCLUIR
    @DeleteMapping("/cnpj/{cnpj}")
    public void deletar(@PathVariable String cnpj) {
        service.deletar(cnpj);
    }
}