package com.distribuidora.ModuloProduto.repository;

import com.distribuidora.ModuloProduto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByCodigo(String codigo);

}