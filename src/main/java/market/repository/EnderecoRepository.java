package market.repository;

import market.model.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<Endereco, Long> {
}
