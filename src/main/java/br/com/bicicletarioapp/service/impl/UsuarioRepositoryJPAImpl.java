package br.com.bicicletarioapp.repository.impl;

import br.com.bicicletarioapp.model.Usuario;
import br.com.bicicletarioapp.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;

public abstract class UsuarioRepositoryJPAImpl implements UsuarioRepository {

    private final EntityManager em;

    public UsuarioRepositoryJPAImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Usuario usuario) {
        em.getTransaction().begin();
        if (usuario.getId() == null) {  // ← CORRIGIDO: usar getId() em vez de getUsuario_id()
            em.persist(usuario);
        } else {
            em.merge(usuario);
        }
        em.getTransaction().commit();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public Usuario buscarPorNome(String nome) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome", Usuario.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
    }

    @Override
    public void atualizar(Usuario usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    @Override
    public void save(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }

    @Override
    public Usuario findByNome(String nome) {
        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.nome = :nome", Usuario.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void excluir(Long id) {
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.remove(usuario);
        }
        em.getTransaction().commit();
    }
}
