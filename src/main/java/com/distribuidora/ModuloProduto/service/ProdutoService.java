package com.distribuidora.ModuloProduto.service;

import com.distribuidora.ModuloFornecedor.entity.Fornecedor;
import com.distribuidora.ModuloFornecedor.repository.FornecedorRepository;

import com.distribuidora.ModuloProduto.dto.ProdutoDTO;
import com.distribuidora.ModuloProduto.entity.Produto;
import com.distribuidora.ModuloProduto.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Produto cadastrar(ProdutoDTO dto) {
        Fornecedor fornecedor = fornecedorRepository.findByCnpj(dto.getCnpjFornecedor()).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        Produto produto = new Produto();
        produto.setCodigo(dto.getCodigo());
        produto.setNomeProduto(dto.getNomeProduto());
        produto.setMarca(dto.getMarca());
        produto.setPrecoBase(dto.getPrecoBase());
        produto.setFornecedor(fornecedor);

        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizar(String codigo, ProdutoDTO dto) {
        Produto produto = buscarPorCodigo(codigo);

        Fornecedor fornecedor = fornecedorRepository.findByCnpj(dto.getCnpjFornecedor()).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        produto.setCodigo(dto.getCodigo());
        produto.setNomeProduto(dto.getNomeProduto());
        produto.setMarca(dto.getMarca());
        produto.setPrecoBase(dto.getPrecoBase());
        produto.setFornecedor(fornecedor);

        return produtoRepository.save(produto);
    }

    public void deletar(String codigo) {
        Produto produto = buscarPorCodigo(codigo);
        produtoRepository.delete(produto);
    }
}
