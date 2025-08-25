package br.com.bicicletarioapp.controller;

import br.com.bicicletarioapp.dto.AluguelDTO;
import br.com.bicicletarioapp.model.Aluguel;
import br.com.bicicletarioapp.model.Bicicleta;
import br.com.bicicletarioapp.model.Cliente;
import br.com.bicicletarioapp.service.IAluguelService;
import br.com.bicicletarioapp.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelController {

    private final IAluguelService aluguelService;

    public AluguelController(IAluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public AluguelDTO registrarAluguel(AluguelDTO aluguelDTO) {
        Aluguel aluguel = convertToEntity(aluguelDTO);
        aluguel = aluguelService.registrarAluguel(aluguel);
        return convertToDTO(aluguel);
    }

    public void finalizarAluguel(Long aluguelId) {
        aluguelService.finalizarAluguel(aluguelId);
    }

    public List<AluguelDTO> listarAlugueis() {
        return aluguelService.listarAlugueis().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AluguelDTO> listarAlugueisPorCliente(Long clienteId) {
        return aluguelService.listarAlugueisPorCliente(clienteId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public double calcularTotalGastoPorCliente(Long clienteId) {
        return aluguelService.calcularTotalGastoPorCliente(clienteId);
    }

    private AluguelDTO convertToDTO(Aluguel aluguel) {
        AluguelDTO dto = new AluguelDTO();
        dto.setClienteId(aluguel.getCliente().getId().longValue()); // Integer → Long

        dto.setBicicletaId(aluguel.getBicicleta().getId());
        dto.setHoraInicio(aluguel.getHoraInicio());
        dto.setHoraTermino(aluguel.getHoraTermino());
        dto.setPrecoHora(aluguel.getPrecoHora());
        return dto;
    }

    private Aluguel convertToEntity(AluguelDTO dto) {
        Aluguel aluguel = new Aluguel();
        aluguel.setId(dto.getId());
            EntityManager em = JPAUtil.getEntityManager();
    try {
        Cliente cliente = em.find(Cliente.class, dto.getClienteId().intValue()); // Long → Integer
        Bicicleta bicicleta = em.find(Bicicleta.class, dto.getBicicletaId());
        
        aluguel.setCliente(cliente);
        aluguel.setBicicleta(bicicleta);
    } finally {
        em.close();
    }
    
    aluguel.setHoraInicio(dto.getHoraInicio());
    aluguel.setHoraTermino(dto.getHoraTermino());
    aluguel.setPrecoHora(dto.getPrecoHora());
    return aluguel;
}
}
