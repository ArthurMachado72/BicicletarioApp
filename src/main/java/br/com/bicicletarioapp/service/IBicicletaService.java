package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Bicicleta;
import java.util.List;

public interface IBicicletaService {
    Bicicleta cadastrarBicicleta(Bicicleta bicicleta);
    Bicicleta atualizarBicicleta(Bicicleta bicicleta);
    void excluirBicicleta(Long id);
    List<Bicicleta> listarBicicletas();
    List<Bicicleta> listarBicicletasPorStatus(String status);
    Bicicleta buscarBicicletaPorId(Long id);
}
