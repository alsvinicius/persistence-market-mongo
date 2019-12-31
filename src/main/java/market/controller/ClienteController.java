package market.controller;

import market.model.Cliente;
import market.service.ClienteService;
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
    private ClienteService service;

    @PostMapping("/inserir")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente inserir(
            @RequestBody Cliente cliente
    ) {
        return service.inserir(cliente);
    }

    @PatchMapping("/alterar/{id}")
    @ResponseBody
    public Optional<Cliente> alterar(
            @PathVariable Long id,
            @RequestBody Cliente cliente
    ) {
        return service.alterar(id, cliente);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id
    ) {
        service.excluir(id);
    }

    @GetMapping
    @ResponseBody
    public List<Cliente> listar() {
        return service.listar();
    }
}
