package com.distribuidora.ModuloEstoque.service;

import com.distribuidora.ModuloEstoque.dto.EstoqueDTO;
import com.distribuidora.ModuloEstoque.entity.Estoque;
import com.distribuidora.ModuloEstoque.repository.EstoqueRepository;

import com.distribuidora.ModuloProduto.entity.Produto;
import com.distribuidora.ModuloProduto.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Estoque cadastrar(EstoqueDTO dto) {
        Produto produto = produtoRepository.findByCodigo(dto.getCodigoProduto()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Estoque estoque = new Estoque();

        estoque.setProduto(produto);
        estoque.setQuantidade(dto.getQuantidade());

        return estoqueRepository.save(estoque);
    }

    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    public Estoque buscarPorCodigo(String codigo) {
        return estoqueRepository.findByProdutoCodigo(codigo).orElseThrow(() -> new RuntimeException("Produto não encontrado no estoque"));
    }

    public Estoque atualizar(String codigo, EstoqueDTO dto) {
        Estoque estoque = buscarPorCodigo(codigo);

        estoque.setQuantidade(dto.getQuantidade());

        return estoqueRepository.save(estoque);
    }

    public void deletar(String codigo) {
        Estoque estoque = buscarPorCodigo(codigo);

        estoqueRepository.delete(estoque);
    }
}