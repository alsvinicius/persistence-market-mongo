package market.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import market.model.Endereco;
import market.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes/{id_cliente}/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository repository;

    @PostMapping("/inserir")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco inserir(
            @PathVariable("id_cliente") Long idCliente,
            @RequestBody Endereco endereco
    ) {
        endereco.setIdCliente(idCliente);
        repository.insert(endereco);
        return endereco;
    }

    @PatchMapping("/alterar/{id}")
    @ResponseBody
    public Optional<Endereco> alterar(
            @PathVariable("id_cliente") Long idCliente,
            @PathVariable Long id,
            @RequestBody Endereco endereco
    ) {
        endereco.setIdCliente(idCliente);
        endereco.setIdEndereco(id);
        repository.save(endereco);
        return repository.findById(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable("id_cliente") Long idCliente,
            @PathVariable Long id
    ) {
        Endereco endereco = new Endereco();
        endereco.setIdCliente(idCliente);
        endereco.setIdEndereco(id);
        repository.delete(endereco);
    }

    @GetMapping
    @ResponseBody
    public List<Endereco> listar(
            @PathVariable("id_cliente") Long idCliente
    ) {
        return repository.findByClient(idCliente);
    }
    
}
