package market.service;

import market.model.PedidoProduto;
import market.model.Produto;
import market.repository.PedidoProdutoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PedidoProdutoService {

    @Autowired
    PedidoProdutoRepository repository;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    PedidoService pedidoService;

    public PedidoProduto inserir(String idPedido, PedidoProduto pedidoProduto) throws HttpClientErrorException{
        Produto produto = produtoService.obter(pedidoProduto.getIdProduto());
        if(produto == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Produto não existente");
        } else {
            if (produto.getQuantidade() <= 0) {
                throw new HttpClientErrorException(HttpStatus.PRECONDITION_FAILED, "Produto não possui quantidade disponível");
            } else {
                produto.setQuantidade(produto.getQuantidade()-1);
                produtoService.alterar(produto.getIdProduto(), produto);
            }
        }

        pedidoProduto.setIdPedido(idPedido);
        pedidoProduto.setIdPedidoProduto(new ObjectId().toString());
        repository.insert(pedidoProduto);
        pedidoService.adicionarValorProduto(idPedido, produto.getValor());
        return pedidoProduto;
    }

    public void excluir(String idPedido, String idProduto) {
        List<PedidoProduto> produtosPedido = repository.findByPedidoProduto(idPedido, idProduto);
        if(produtosPedido != null) {
            PedidoProduto pedidoProduto = produtosPedido.get(0);
            Produto produto = produtoService.obter(idProduto);
            repository.delete(pedidoProduto);
            pedidoService.removerValorProduto(idPedido, produto.getValor());
            produto.setQuantidade(produto.getQuantidade() + 1);
            produtoService.alterar(idProduto, produto);
        }
    }

    public List<PedidoProduto> listar(String idPedido) {
        return repository.findByPedido(idPedido);
    }

}
