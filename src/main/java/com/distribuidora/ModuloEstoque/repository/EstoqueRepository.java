package com.distribuidora.ModuloEstoque.repository;

import com.distribuidora.ModuloEstoque.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByProdutoCodigo(String codigo);
}
