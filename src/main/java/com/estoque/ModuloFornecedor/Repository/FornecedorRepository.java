package com.estoque.ModuloFornecedor.Repository;

import com.estoque.ModuloFornecedor.Entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
