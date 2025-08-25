package br.com.bicicletarioapp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AluguelDTO {
    private Long id;
    private Long clienteId;
    private Long bicicletaId;
    private Long usuarioId;
    private LocalDateTime horaInicio;
    private LocalDateTime horaTermino; // pode ser null
    private BigDecimal precoHora;

    public AluguelDTO() {}

    public AluguelDTO(Long id, Long clienteId, Long bicicletaId, Long usuarioId,
                      LocalDateTime horaInicio, LocalDateTime horaTermino, BigDecimal precoHora) {
        this.id = id;
        this.clienteId = clienteId;
        this.bicicletaId = bicicletaId;
        this.usuarioId = usuarioId;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.precoHora = precoHora;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getBicicletaId() { return bicicletaId; }
    public void setBicicletaId(Long bicicletaId) { this.bicicletaId = bicicletaId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public LocalDateTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalDateTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalDateTime getHoraTermino() { return horaTermino; }
    public void setHoraTermino(LocalDateTime horaTermino) { this.horaTermino = horaTermino; }

    public BigDecimal getPrecoHora() { return precoHora; }
    public void setPrecoHora(BigDecimal precoHora) { this.precoHora = precoHora; }
}
