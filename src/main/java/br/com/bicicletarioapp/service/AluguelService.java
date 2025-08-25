package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Aluguel;
import br.com.bicicletarioapp.repository.AluguelRepository;
import br.com.bicicletarioapp.repository.IAluguelRepository;
import br.com.bicicletarioapp.repository.impl.AluguelRepositoryJPAImpl;
import br.com.bicicletarioapp.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

public class AluguelService implements IAluguelService {

    private IAluguelRepository aluguelRepository;

    public AluguelService(EntityManager em) {

        this.aluguelRepository = new AluguelRepository(em);
    }

    public AluguelService(IAluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public Aluguel registrarAluguel(Aluguel aluguel) {
        if (aluguel.getCliente() == null || aluguel.getBicicleta() == null) {
            throw new IllegalArgumentException("Cliente e bicicleta são obrigatórios");
        }

        // Se as datas não foram setadas, defina valores padrão
        if (aluguel.getHoraInicio() == null) {
            aluguel.setHoraInicio(LocalDateTime.now());
        }
        if (aluguel.getHoraTermino() == null) {
            aluguel.setHoraTermino(aluguel.getHoraInicio().plusHours(1));
        }
        return aluguelRepository.save(aluguel);
    }

    @Override
    public void finalizarAluguel(Long aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId);
        if (aluguel == null) {
            throw new IllegalArgumentException("Aluguel não encontrado");
        }
        aluguel.setHoraTermino(LocalDateTime.now());
        aluguelRepository.save(aluguel);
    }

    @Override
    public List<Aluguel> listarAlugueis() {
        return aluguelRepository.findAll();
    }

    @Override
    public List<Aluguel> listarAlugueisPorCliente(Long clienteId) {
        return aluguelRepository.findByClienteId(clienteId);
    }

    @Override
    public double calcularTotalGastoPorCliente(Long clienteId) {
        var alugueis = aluguelRepository.findByClienteId(clienteId);

        BigDecimal total = alugueis.stream()
                .map(a -> {
                    long horas = Duration.between(
                            a.getHoraInicio(),
                            a.getHoraTermino() != null ? a.getHoraTermino() : LocalDateTime.now()
                    ).toHours();

                    return a.getPrecoHora().multiply(BigDecimal.valueOf(horas));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total.doubleValue();
    }

    public Aluguel salvarAluguel(Aluguel aluguel) {
        try {
            return aluguelRepository.save(aluguel); // ← Aqui pode estar o problema
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar aluguel: " + e.getMessage(), e);
        }
    }

    public void excluirAluguel(Long aluguelId) {
        aluguelRepository.delete(aluguelId);
    }
}
