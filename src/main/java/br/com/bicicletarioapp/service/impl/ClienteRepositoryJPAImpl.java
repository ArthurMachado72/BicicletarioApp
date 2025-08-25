package br.com.bicicletarioapp.repository.impl;

import br.com.bicicletarioapp.model.Cliente;
import br.com.bicicletarioapp.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ClienteRepositoryJPAImpl extends ClienteRepository {

    private EntityManager em;

    public ClienteRepositoryJPAImpl(EntityManager em) {
        super(em);
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public Cliente save(Cliente cliente) {
        em.getTransaction().begin();
        if (cliente.getId() == null) {
            em.persist(cliente);
        } else {
            cliente = em.merge(cliente);
        }
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

       @Override
    public List<Cliente> findByNome(String nome) {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    @Override
    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return query.getResultList();
    }

       @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        Cliente cliente = findById(id);
        if (cliente != null) {
            em.remove(cliente);
        }
        em.getTransaction().commit();
    }
}
