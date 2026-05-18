package ModuloFornecedor.Service;

import ModuloFornecedor.Entity.Fornecedor;
import ModuloFornecedor.Repository.FornecedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    // CADASTRAR
    public Fornecedor cadastrar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    // LISTAR TODOS
    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR
    public Optional<Fornecedor> buscarPorCnpj(String cnpj) {
        return repository.findByCnpj(cnpj);
    }

    // ATUALIZAR
    public Fornecedor atualizar(String cnpj, Fornecedor dados) {

        return repository.findByCnpj(cnpj).map(f -> {

            f.setNome(dados.getNome());
            f.setTelefone(dados.getTelefone());
            f.setEndereco(dados.getEndereco());
            f.setCidade(dados.getCidade());
            f.setProdutoFornecidoA(dados.getProdutoFornecidoA());
            f.setProdutoFornecidoB(dados.getProdutoFornecidoB());

            return repository.save(f);

        }).orElseThrow(() ->
                new RuntimeException("Fornecedor não encontrado"));
    }

    // EXCLUIR
    public void deletar(String cnpj) {

        Fornecedor fornecedor = repository.findByCnpj(cnpj)
                .orElseThrow(() ->
                        new RuntimeException("Fornecedor não encontrado"));

        repository.delete(fornecedor);
    }
}