package com.estoque.ModuloCliente.Repository;

import com.estoque.ModuloCliente.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
