package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Aluguel;
import java.util.List;

public interface IAluguelRepository {
    Aluguel save(Aluguel aluguel);
    Aluguel findById(Long id);
    List<Aluguel> findAll();
    List<Aluguel> findByClienteId(Long clienteId);
    List<Aluguel> findByBicicletaId(Long bicicletaId);
    void delete(Long id);
}
