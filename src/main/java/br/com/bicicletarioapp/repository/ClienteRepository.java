package br.com.bicicletarioapp.repository;

import br.com.bicicletarioapp.model.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ClienteRepository implements IClienteRepository {
    public final EntityManager em;

    public ClienteRepository(EntityManager em) {
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
    public List<Cliente> findAll() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
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
