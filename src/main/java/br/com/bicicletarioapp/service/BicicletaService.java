package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Bicicleta;
import br.com.bicicletarioapp.repository.IBicicletaRepository;
import java.util.List;

public class BicicletaService {
    
    private final IBicicletaRepository bicicletaRepository;
    
    public BicicletaService(IBicicletaRepository bicicletaRepository) {
        this.bicicletaRepository = bicicletaRepository;
    }
    
    public Bicicleta salvarBicicleta(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }
    
    public Bicicleta buscarPorId(Long id) {
        return bicicletaRepository.findById(id);
    }
    
    public Bicicleta buscarPorNumero(String numero) {
        return bicicletaRepository.findByNumero(numero);
    }
    
    public List<Bicicleta> listarTodas() {
        return bicicletaRepository.findAll();
    }
    
    public List<Bicicleta> listarPorStatus(String status) {
        return bicicletaRepository.findByStatus(status);
    }
    
    public void excluirBicicleta(Long id) {
        bicicletaRepository.delete(id);
    }
}
