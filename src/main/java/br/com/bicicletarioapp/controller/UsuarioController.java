package br.com.bicicletarioapp.controller;

import br.com.bicicletarioapp.model.Usuario;
import br.com.bicicletarioapp.service.UsuarioService;
import br.com.bicicletarioapp.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UsuarioController {
    
    private UsuarioService usuarioService;
    private EntityManager em;
    
    public UsuarioController() {
        this.em = JPAUtil.getEntityManager();
        this.usuarioService = new UsuarioService(em);
    }
    
    // Cadastrar usuário
    public boolean cadastrarUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        return usuarioService.cadastrar(usuario);
    }
    
    // Buscar usuário por nome
    public Usuario buscarUsuarioPorNome(String nome) {
        return usuarioService.buscarUsuarioPorNome(nome);
    }
    
    // Listar todos os usuários (se tiver este método no repository)
    public List<Usuario> listarTodosUsuarios() {
        // Implemente conforme seu repository
        return null;
    }
    
    // Fechar conexão
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}