package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Bicicleta;
import java.util.List;

public interface IBicicletaRepository {
    Bicicleta save(Bicicleta bicicleta);
    Bicicleta findById(Long id);
    List<Bicicleta> findAll();
    List<Bicicleta> findByStatus(String status);
    Bicicleta findByNumero(String numero);
    void delete(Long id);
}
