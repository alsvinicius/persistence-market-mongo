package market.service;

import market.model.Endereco;
import market.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EnderecoService {
    
    @Autowired
    EnderecoRepository repository;

    public Endereco inserir(Endereco endereco, Long idCliente) {
        endereco.setIdCliente(idCliente);
        repository.insert(endereco);
        return endereco;
    }

    public Optional<Endereco> alterar(Long id, Long idCliente, Endereco endereco) {
        endereco.setIdCliente(idCliente);
        endereco.setIdEndereco(id);
        repository.save(endereco);
        return repository.findById(id);
    }

    public void excluir(Long id, Long idCliente) {
        Endereco endereco = new Endereco();
        endereco.setIdCliente(idCliente);
        endereco.setIdEndereco(id);
        repository.delete(endereco);
    }

    public List<Endereco> listar(Long idCliente) {
        return repository.findByClient(idCliente);
    }
    
}
