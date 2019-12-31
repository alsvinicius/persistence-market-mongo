package market.service;

import market.model.Pedido;
import market.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public Pedido inserir( Long idCliente, Pedido pedido) {
        pedido.setIdCliente(idCliente);
        repository.insert(pedido);
        return pedido;
    }

    public Optional<Pedido> alterar(Long idCliente, Long id, Pedido pedido) {
        pedido.setIdCliente(idCliente);
        pedido.setIdPedido(id);
        repository.save(pedido);
        return repository.findById(id);
    }

    public void excluir(Long idCliente, Long id) {
        Pedido pedido = new Pedido();
        pedido.setIdCliente(idCliente);
        pedido.setIdPedido(id);
        repository.delete(pedido);
    }

    public List<Pedido> listar(Long idCliente) {
        return repository.findByClient(idCliente);
    }

    public void adicionarValorProduto(long idPedido, double valor) {
        Optional<Pedido> optionalPedido = repository.findById(idPedido);
        optionalPedido.ifPresent(pedido -> {
            pedido.setValor(pedido.getValor() + valor);
        });
    }

    public void removerValorProduto(long idPedido, double valor) {
        Optional<Pedido> optionalPedido = repository.findById(idPedido);
        optionalPedido.ifPresent(pedido -> {
            pedido.setValor(pedido.getValor() - valor);
        });
    }

}
