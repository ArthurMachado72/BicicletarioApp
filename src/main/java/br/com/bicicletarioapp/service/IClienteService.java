package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Cliente;
import java.util.List;

public interface IClienteService {
    Cliente cadastrarCliente(Cliente cliente);
    Cliente atualizarCliente(Cliente cliente);
    void excluirCliente(Long id);
    List<Cliente> listarClientes();
    List<Cliente> buscarClientesPorNome(String nome);
    Cliente buscarClientePorId(Long id);
}