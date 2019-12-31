package market.service;

import market.model.PedidoProduto;
import market.repository.PedidoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PedidoProdutoService {

    @Autowired
    PedidoProdutoRepository repository;

    public PedidoProduto inserir(Long idPedido, PedidoProduto pedidoProduto) {
        pedidoProduto.setIdPedido(idPedido);
        repository.insert(pedidoProduto);
        return pedidoProduto;
    }

    public void excluir(Long idPedido, Long id) {
        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setIdPedido(idPedido);
        pedidoProduto.setIdPedidoProduto(id);
        repository.delete(pedidoProduto);
    }

    public List<PedidoProduto> listar(Long idPedido) {
        return repository.findByPedido(idPedido);
    }

}
