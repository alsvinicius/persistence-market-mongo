package market.repository;

import market.model.PedidoProduto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoProdutoRepository extends MongoRepository<PedidoProduto, Long> {
}
