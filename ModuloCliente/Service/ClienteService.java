package ModuloCliente.Service;

import ModuloCliente.Entity.Cliente;
import ModuloCliente.Repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
   @Autowired
   private ClienteRepository repository;

   public ClienteService() {
   }

   public Cliente cadastrar(Cliente fornecedor) {
      return (Cliente)this.repository.save(fornecedor);
   }

   public List<Cliente> listarTodos() {
      return this.repository.findAll();
   }

   public Optional<Cliente> buscarPorId(Long id) {
      return this.repository.findById(id);
   }

   public Cliente atualizar(Long id, Cliente dados) {
      return (Cliente)this.repository.findById(id).map((f) -> {
         f.setNome(dados.getNome());
         f.setCnpj(dados.getCpf());
         f.setTelefone(dados.getTelefone());
         f.setEndereco(dados.getEndereco());
         return (Cliente)this.repository.save(f);
      }).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
   }

   public void deletar(Long id) {
      this.repository.deleteById(id);
   }
}