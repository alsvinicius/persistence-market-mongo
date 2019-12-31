package market.repository;

import market.model.PedidoProduto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PedidoProdutoRepository extends MongoRepository<PedidoProduto, Long> {

    @Query("{'idPedido': ?0}")
    List<PedidoProduto> findByPedido(Long idPedido);
}
