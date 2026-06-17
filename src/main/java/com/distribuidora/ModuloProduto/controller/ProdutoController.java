package com.distribuidora.ModuloProduto.controller;

import com.distribuidora.ModuloProduto.dto.ProdutoDTO;
import com.distribuidora.ModuloProduto.entity.Produto;
import com.distribuidora.ModuloProduto.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public Produto cadastrar(@RequestBody ProdutoDTO dto) {
        return service.cadastrar(dto);
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/codigo/{codigo}")
    public Produto buscar(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PutMapping("/codigo/{codigo}")
    public Produto atualizar(@PathVariable String codigo, @RequestBody ProdutoDTO dto) {
        return service.atualizar(codigo, dto);
    }

    @DeleteMapping("/codigo/{codigo}")
    public void deletar(@PathVariable String codigo) {
        service.deletar(codigo);
    }
}