package market.service;

import market.model.Pedido;
import market.repository.PedidoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public Pedido inserir(String idCliente, Pedido pedido) {
        pedido.setIdCliente(idCliente);
        pedido.setIdPedido(new ObjectId().toString());
        repository.insert(pedido);
        return pedido;
    }

    public Optional<Pedido> alterar(String idCliente, String id, Pedido pedido) {
        pedido.setIdCliente(idCliente);
        pedido.setIdPedido(id);
        repository.save(pedido);
        return repository.findById(id);
    }

    public void excluir(String idCliente, String id) {
        Pedido pedido = new Pedido();
        pedido.setIdCliente(idCliente);
        pedido.setIdPedido(id);
        repository.delete(pedido);
    }

    public List<Pedido> listar(String idCliente) {
        return repository.findByClient(idCliente);
    }

    public void adicionarValorProduto(String idPedido, double valor) {
        Optional<Pedido> optionalPedido = repository.findById(idPedido);
        optionalPedido.ifPresent(pedido -> {
            pedido.setValor(pedido.getValor() + valor);
            alterar(pedido.getIdCliente(), idPedido, pedido);
        });
    }

    public void removerValorProduto(String idPedido, double valor) {
        Optional<Pedido> optionalPedido = repository.findById(idPedido);
        optionalPedido.ifPresent(pedido -> {
            pedido.setValor(pedido.getValor() - valor);
            alterar(pedido.getIdCliente(), idPedido, pedido);
        });
    }

}
