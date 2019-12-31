package market.controller;

import market.model.Produto;
import market.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping("/inserir")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(
            @RequestBody Produto produto
    ) {
        return service.inserir(produto);
    }

    @PatchMapping("/alterar/{id}")
    @ResponseBody
    public Optional<Produto> alterar(
            @PathVariable Long id,
            @RequestBody Produto produto
    ) {
        return service.alterar(id, produto);
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
    public List<Produto> listar() {
        return service.listar();
    }

}
