package br.com.bicicletarioapp.controller;

import br.com.bicicletarioapp.dto.ClienteDTO;
import br.com.bicicletarioapp.model.Cliente;
import br.com.bicicletarioapp.service.IClienteService;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteController {
    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertToEntity(clienteDTO);
        cliente = clienteService.cadastrarCliente(cliente);
        return convertToDTO(cliente);
    }

    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertToEntity(clienteDTO);
        cliente = clienteService.atualizarCliente(cliente);
        return convertToDTO(cliente);
    }

    public void excluirCliente(Long id) {
        clienteService.excluirCliente(id);
    }

    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ClienteDTO> buscarClientesPorNome(String nome) {
        return clienteService.buscarClientesPorNome(nome).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarClientePorId(Long id) {
        return convertToDTO(clienteService.buscarClientePorId(id));
    }

    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setContato(cliente.getContato());
        return dto;
    }

    private Cliente convertToEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setContato(dto.getContato());
        return cliente;
    }
}