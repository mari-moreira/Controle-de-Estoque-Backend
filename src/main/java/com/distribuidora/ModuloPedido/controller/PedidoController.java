package com.distribuidora.ModuloPedido.controller;

import com.distribuidora.ModuloPedido.DTO.PedidoDTO;
import com.distribuidora.ModuloPedido.entity.Pedido;
import com.distribuidora.ModuloPedido.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    // CADASTRAR
    @PostMapping
    public Pedido cadastrar(@RequestBody PedidoDTO dto) {
        return service.cadastrar(dto);
    }

    // LISTAR TODOS
    @GetMapping
    public List<Pedido> listar() {
        return service.listarTodos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        return service.atualizar(id, dto);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}