package br.com.bicicletarioapp.controller;

import br.com.bicicletarioapp.dto.BicicletaDTO;
import br.com.bicicletarioapp.model.Bicicleta;
import br.com.bicicletarioapp.service.IBicicletaService;
import java.util.List;
import java.util.stream.Collectors;

public class BicicletaController {
    private final IBicicletaService bicicletaService;

    public BicicletaController(IBicicletaService bicicletaService) {
        this.bicicletaService = bicicletaService;
    }

    public BicicletaDTO cadastrarBicicleta(BicicletaDTO bicicletaDTO) {
        Bicicleta bicicleta = convertToEntity(bicicletaDTO);
        bicicleta = bicicletaService.cadastrarBicicleta(bicicleta);
        return convertToDTO(bicicleta);
    }

    public BicicletaDTO atualizarBicicleta(BicicletaDTO bicicletaDTO) {
        Bicicleta bicicleta = convertToEntity(bicicletaDTO);
        bicicleta = bicicletaService.atualizarBicicleta(bicicleta);
        return convertToDTO(bicicleta);
    }

    public void excluirBicicleta(Long id) {
        bicicletaService.excluirBicicleta(id);
    }

    public List<BicicletaDTO> listarBicicletas() {
        return bicicletaService.listarBicicletas().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BicicletaDTO> listarBicicletasPorStatus(String status) {
        return bicicletaService.listarBicicletasPorStatus(status).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BicicletaDTO buscarBicicletaPorId(Long id) {
        return convertToDTO(bicicletaService.buscarBicicletaPorId(id));
    }

    private BicicletaDTO convertToDTO(Bicicleta bicicleta) {
        BicicletaDTO dto = new BicicletaDTO();
        dto.setId(bicicleta.getId());
        dto.setNumero(bicicleta.getNumero());
        dto.setStatus(bicicleta.getStatus());
        return dto;
    }

    private Bicicleta convertToEntity(BicicletaDTO dto) {
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setId(dto.getId());
        bicicleta.setNumero(dto.getNumero());
        bicicleta.setStatus(dto.getStatus());
        return bicicleta;
    }
}