package com.estoque.ModuloFornecedor.Service;

import com.estoque.ModuloFornecedor.Repository.FornecedorRepository;
import com.estoque.ModuloFornecedor.Entity.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor cadastrar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Fornecedor atualizar(Long id, Fornecedor dados) {
        return repository.findById(id).map(f -> {
            f.setNome(dados.getNome());
            f.setCnpj(dados.getCnpj());
            f.setTelefone(dados.getTelefone());
            f.setEndereco(dados.getEndereco());
            f.setCidade(dados.getCidade());
            f.setProdutoFornecidoA(dados.getProdutoFornecidoA());
            f.setProdutoFornecidoB(dados.getProdutoFornecidoB());
            return repository.save(f);
        }).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}