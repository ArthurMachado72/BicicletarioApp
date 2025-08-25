package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Aluguel;
import jakarta.persistence.EntityManager;
import java.util.List;

public abstract class AluguelRepositoryJPAImpl {
    private EntityManager em;
    
    public AluguelRepositoryJPAImpl(EntityManager em) {
        this.em = em;
    }
    
    protected EntityManager getEm() {
        return em;
    }
    
    public abstract Aluguel save(Aluguel aluguel);
    public abstract Aluguel findById(Long id);
    public abstract List<Aluguel> findAll();
    public abstract void delete(Long id);
    public abstract List<Aluguel> findByClienteId(Long clienteId);
}
