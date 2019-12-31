package market.service;

import market.model.Produto;
import market.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto inserir(Produto produto) {
        repository.insert(produto);
        return produto;
    }

    public Optional<Produto> alterar(Long id, Produto produto) {
        produto.setIdProduto(id);
        repository.save(produto);
        return repository.findById(id);
    }

    public void excluir(Long id) {
        Produto produto = new Produto();
        produto.setIdProduto(id);
        repository.delete(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }
}
