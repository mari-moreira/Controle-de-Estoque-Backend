package com.distribuidora.ModuloPedido.service;

import com.distribuidora.ModuloCliente.entity.Cliente;
import com.distribuidora.ModuloCliente.repository.ClienteRepository;
import com.distribuidora.ModuloEstoque.entity.Estoque;
import com.distribuidora.ModuloEstoque.repository.EstoqueRepository;
import com.distribuidora.ModuloProduto.entity.Produto;
import com.distribuidora.ModuloProduto.repository.ProdutoRepository;

import com.distribuidora.ModuloPedido.DTO.PedidoDTO;
import com.distribuidora.ModuloPedido.entity.Pedido;
import com.distribuidora.ModuloPedido.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    //CADASTRAR PEDIDO
    public Pedido cadastrar(PedidoDTO dto) {

        // BUSCAR CLIENTE
        Cliente cliente = clienteRepository.findByCpf(dto.getCpfCliente()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // BUSCAR PRODUTO
        Produto produto = produtoRepository.findByCodigo(dto.getCodigoProduto()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // BUSCAR ESTOQUE
        Estoque estoque = estoqueRepository.findByProdutoCodigo(dto.getCodigoProduto()).orElseThrow(() -> new RuntimeException("Produto não cadastrado no estoque"));

        if (estoque.getQuantidade() < dto.getQuantidade()) {
            throw new RuntimeException("Quantidade insuficiente em estoque");
        } else {
            estoque.setQuantidade(estoque.getQuantidade() - dto.getQuantidade());
            estoqueRepository.save(estoque);
        }

        // CALCULAR VALOR
        Double valorTotal = produto.getPrecoBase() * dto.getQuantidade();

        // MONTAR PEDIDO
        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(dto.getQuantidade());
        pedido.setFormaPagamento(dto.getFormaPagamento());
        pedido.setValorPedido(valorTotal);

        // SALVAR
        return pedidoRepository.save(pedido);
    }

    // LISTAR PEDIDOS
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    // BUSCAR POR ID
    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    // ATUALIZAR PEDIDO
    public Pedido atualizar(Long id, PedidoDTO dto) {
        
        Pedido pedido = buscarPorId(id);

        Cliente cliente = clienteRepository.findByCpf(dto.getCpfCliente()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Produto produto = produtoRepository.findByCodigo(dto.getCodigoProduto()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Double valorTotal = produto.getPrecoBase() * dto.getQuantidade();

        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(dto.getQuantidade());
        pedido.setFormaPagamento(dto.getFormaPagamento());
        pedido.setValorPedido(valorTotal);

        return pedidoRepository.save(pedido);
    }

    // EXCLUIR PEDIDO
    public void deletar(Long id) {
        Pedido pedido = buscarPorId(id);

        Estoque estoque = estoqueRepository.findByProdutoCodigo(pedido.getProduto().getCodigo()).orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
        estoque.setQuantidade(estoque.getQuantidade() + pedido.getQuantidade());
        estoqueRepository.save(estoque);
        
        pedidoRepository.delete(pedido);
    }
}
