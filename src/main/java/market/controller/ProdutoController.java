package market.controller;

import market.model.Produto;
import market.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/inserir")
    @ResponseBody
    public Produto inserir(
            @RequestBody Produto produto
    ) {
        produtoRepository.insert(produto);
        return produto;
    }

    @PatchMapping("/alterar/{id}")
    @ResponseBody
    public Optional<Produto> alterar(
            @PathVariable Long id,
            @RequestBody Produto produto
    ) {
        produto.setIdProduto(id);
        produtoRepository.save(produto);
        return produtoRepository.findById(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseBody
    public ResponseEntity excluir(
            @PathVariable Long id
    ) {
        Produto produto = new Produto();
        produto.setIdProduto(id);
        produtoRepository.delete(produto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @ResponseBody
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

}
