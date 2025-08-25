package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Usuario;
import br.com.bicicletarioapp.repository.UsuarioRepository;
import br.com.bicicletarioapp.repository.impl.UsuarioRepositoryJPAImpl;
import jakarta.persistence.EntityManager;

public class UsuarioService {

    private UsuarioRepository repository;

        public UsuarioService(EntityManager em) {
        this.repository = new UsuarioRepositoryJPAImpl(em) {
            @Override
            public Usuario findById(Long id) {
                return null;
            }
        };
    }
  public void method(EntityManager em) {
        this.repository = new UsuarioRepositoryJPAImpl(em) {
            @Override
            public Usuario findById(Long id) {
                return null;
           }
        };
    }

    // Cadastrar novo usuário
    public boolean cadastrar(Usuario usuario) {
        try {
            repository.save(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Buscar usuário pelo nome
    public Usuario buscarUsuarioPorNome(String nome) {
        return repository.findByNome(nome);
    }
 
        public Usuario buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID do usuário não pode ser nulo");
        }
        return repository.findById(id);
    }
    // Autenticar usuário (usado no Login)
    public Usuario autenticar(String nome, String senha) {
        Usuario usuario = buscarUsuarioPorNome(nome);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }
}
