package market.controller;

import market.model.Produto;
import market.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseBody
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

}
