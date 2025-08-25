package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Aluguel;
import java.util.List;

public interface IAluguelService {
    Aluguel registrarAluguel(Aluguel aluguel);
    void finalizarAluguel(Long aluguelId);
    List<Aluguel> listarAlugueis();
    List<Aluguel> listarAlugueisPorCliente(Long clienteId);
    double calcularTotalGastoPorCliente(Long clienteId);
}