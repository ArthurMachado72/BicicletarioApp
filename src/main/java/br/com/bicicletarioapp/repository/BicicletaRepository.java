package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Bicicleta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;

public class BicicletaRepository implements IBicicletaRepository {

    private final EntityManager em;

    public BicicletaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Bicicleta save(Bicicleta bicicleta) {
        em.getTransaction().begin();
        if (bicicleta.getId() == null) {
            em.persist(bicicleta);
        } else {
            bicicleta = em.merge(bicicleta);
        }
        em.getTransaction().commit();
        return bicicleta;
    }

    @Override
    public Bicicleta findById(Long id) {
        return em.find(Bicicleta.class, id);
    }

    @Override
    public List<Bicicleta> findAll() {
        return em.createQuery("SELECT b FROM Bicicleta b", Bicicleta.class)
                .getResultList();
    }

    @Override
    public List<Bicicleta> findByStatus(String status) {
        return em.createQuery("SELECT b FROM Bicicleta b WHERE b.status = :status", Bicicleta.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public Bicicleta findByNumero(String numero) {
        try {
            return em.createQuery("SELECT b FROM Bicicleta b WHERE b.numero = :numero", Bicicleta.class)
                    .setParameter("numero", numero)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Bicicleta bicicleta = findById(id);
        if (bicicleta != null) {
            em.remove(bicicleta);
        }
        em.getTransaction().commit();
    }
}