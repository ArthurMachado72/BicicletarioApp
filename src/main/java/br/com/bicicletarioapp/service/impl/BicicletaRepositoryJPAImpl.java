package br.com.bicicletarioapp.repository.impl;

import br.com.bicicletarioapp.model.Bicicleta;
import br.com.bicicletarioapp.repository.BicicletaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public abstract class BicicletaRepositoryJPAImpl extends BicicletaRepository {

    private EntityManager em;

    public BicicletaRepositoryJPAImpl(EntityManager em) {
        super(em);
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
    public Bicicleta findByNumero(String numero) {
        TypedQuery<Bicicleta> query = em.createQuery(
            "SELECT b FROM Bicicleta b WHERE b.numero = :numero", Bicicleta.class);
        query.setParameter("numero", numero);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Bicicleta> findAll() {
        TypedQuery<Bicicleta> query = em.createQuery("SELECT b FROM Bicicleta b", Bicicleta.class);
        return query.getResultList();
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Bicicleta bicicleta = em.find(Bicicleta.class, id);
        if (bicicleta != null) {
            em.remove(bicicleta);
        }
        em.getTransaction().commit();
    }
}