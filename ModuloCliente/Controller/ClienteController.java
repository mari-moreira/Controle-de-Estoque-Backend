package ModuloCliente.Controller;

import ModuloCliente.Entity.Cliente;
import ModuloCliente.Service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/fornecedores"})
public class ClienteController {
   @Autowired
   private ClienteService service;

   public ClienteController() {
   }

   @PostMapping
   public Cliente cadastrar(@RequestBody Cliente fornecedor) {
      return this.service.cadastrar(fornecedor);
   }

   @GetMapping
   public List<Cliente> listar() {
      return this.service.listarTodos();
   }

   @GetMapping({"/{id}"})
   public Cliente buscar(@PathVariable Long id) {
      return (Cliente)this.service.buscarPorId(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
   }

   @PutMapping({"/{id}"})
   public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
      return this.service.atualizar(id, cliente);
   }

   @DeleteMapping({"/{id}"})
   public void deletar(@PathVariable Long id) {
      this.service.deletar(id);
   }
}
