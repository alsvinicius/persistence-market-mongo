package market.service;

import market.model.Cliente;
import market.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente inserir(Cliente cliente) {
        repository.insert(cliente);
        return cliente;
    }

    public Optional<Cliente> alterar(Long id, Cliente cliente) {
        cliente.setIdCliente(id);
        repository.save(cliente);
        return repository.findById(id);
    }

    public void excluir(Long id) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        repository.delete(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

}
