package market.controller;

import market.model.Cliente;
import market.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @PostMapping("/inserir")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente inserir(
            @RequestBody Cliente cliente
    ) {
        repository.insert(cliente);
        return cliente;
    }

    @PatchMapping("/alterar/{id}")
    @ResponseBody
    public Optional<Cliente> alterar(
            @PathVariable Long id,
            @RequestBody Cliente cliente
    ) {
        cliente.setIdCliente(id);
        repository.save(cliente);
        return repository.findById(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id
    ) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        repository.delete(cliente);
    }

    @GetMapping
    @ResponseBody
    public List<Cliente> listar() {
        return repository.findAll();
    }
}
