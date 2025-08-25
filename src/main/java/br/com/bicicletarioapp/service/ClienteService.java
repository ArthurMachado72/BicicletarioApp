package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Cliente;
import br.com.bicicletarioapp.repository.IClienteRepository;
import java.util.List;

public class ClienteService implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        return clienteRepository.save(cliente);
        
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        if (cliente.getId() == null) {
            throw new IllegalArgumentException("ID do cliente é obrigatório para atualização");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public void excluirCliente(Long id) {
        clienteRepository.delete(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> buscarClientesPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente buscarPorId(Integer clienteId) {
    
        return null;
    
    }

}
