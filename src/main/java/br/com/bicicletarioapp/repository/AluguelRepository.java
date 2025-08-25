package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Aluguel;
import jakarta.persistence.EntityManager;
import java.util.List;

public class AluguelRepository implements IAluguelRepository {

    public final EntityManager em;

    public AluguelRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Aluguel save(Aluguel aluguel) {
        try {
            // Sempre inicie e commit a transação
            em.getTransaction().begin();

            if (aluguel.getId() == null) {
                em.persist(aluguel);
            } else {
                aluguel = em.merge(aluguel);
            }

            
            return aluguel;

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao salvar aluguel", e);
        }
    }

    @Override
    public Aluguel findById(Long id) {
        return em.find(Aluguel.class, id);
    }

    @Override
    public List<Aluguel> findAll() {
        return em.createQuery("SELECT a FROM Aluguel a", Aluguel.class).getResultList();
    }

    @Override
    public List<Aluguel> findByClienteId(Long clienteId) {
        return em.createQuery("SELECT a FROM Aluguel a WHERE a.cliente.id = :clienteId", Aluguel.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
    }

    @Override
    public List<Aluguel> findByBicicletaId(Long bicicletaId) {
        return em.createQuery("SELECT a FROM Aluguel a WHERE a.bicicleta.id = :bicicletaId", Aluguel.class)
                .setParameter("bicicletaId", bicicletaId)
                .getResultList();
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Aluguel aluguel = findById(id);
        if (aluguel != null) {
            em.remove(aluguel);
        }
        em.getTransaction().commit();
    }
}
