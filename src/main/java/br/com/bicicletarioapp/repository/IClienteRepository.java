package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Cliente;
import java.util.List;

public interface IClienteRepository {
    Cliente save(Cliente cliente);
    Cliente findById(Long id);
    List<Cliente> findAll();
    List<Cliente> findByNome(String nome);
    void delete(Long id);
}