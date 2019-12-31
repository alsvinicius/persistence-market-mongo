package market.controller;

import market.model.Produto;
import market.repository.ProdutoRepository;
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
    ProdutoRepository repository;

    @PostMapping("/inserir")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(
            @RequestBody Produto produto
    ) {
        repository.insert(produto);
        return produto;
    }

    @PatchMapping("/alterar/{id}")
    @ResponseBody
    public Optional<Produto> alterar(
            @PathVariable Long id,
            @RequestBody Produto produto
    ) {
        produto.setIdProduto(id);
        repository.save(produto);
        return repository.findById(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable Long id
    ) {
        Produto produto = new Produto();
        produto.setIdProduto(id);
        repository.delete(produto);
    }

    @GetMapping
    @ResponseBody
    public List<Produto> listar() {
        return repository.findAll();
    }

}
