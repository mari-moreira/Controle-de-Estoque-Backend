package com.distribuidora.ModuloEstoque.controller;

import com.distribuidora.ModuloEstoque.dto.EstoqueDTO;
import com.distribuidora.ModuloEstoque.entity.Estoque;
import com.distribuidora.ModuloEstoque.service.EstoqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@CrossOrigin(origins = "*")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @PostMapping
    public Estoque cadastrar(@RequestBody EstoqueDTO dto) {
        return service.cadastrar(dto);
    }

    @GetMapping
    public List<Estoque> listar() {
        return service.listarTodos();
    }

    @GetMapping("/codigo/{codigo}")
    public Estoque buscar(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PutMapping("/codigo/{codigo}")
    public Estoque atualizar(@PathVariable String codigo, @RequestBody EstoqueDTO dto) {
        return service.atualizar(codigo, dto);
    }

    @DeleteMapping("/codigo/{codigo}")
    public void deletar(@PathVariable String codigo) {
        service.deletar(codigo);
    }
}
