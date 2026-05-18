package ModuloCliente.Controller;

import ModuloCliente.Service.ClienteService;
import ModuloCliente.Entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // CADASTRAR
    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return service.cadastrar(cliente);
    }

    // LISTAR TODOS
    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    // BUSCAR
    @GetMapping("/cpf/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {

        return service.buscarPorCpf(cpf)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));
    }

    // ATUALIZAR
    @PutMapping("/cpf/{cpf}")
    public Cliente atualizar(
            @PathVariable String cpf,
            @RequestBody Cliente cliente) {

        return service.atualizar(cpf, cliente);
    }

    // EXCLUIR
    @DeleteMapping("/cpf/{cpf}")
    public void deletar(@PathVariable String cpf) {

        service.deletar(cpf);
    }
}