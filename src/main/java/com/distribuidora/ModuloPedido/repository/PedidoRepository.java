package com.distribuidora.ModuloPedido.repository;

import com.distribuidora.ModuloPedido.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {

}
