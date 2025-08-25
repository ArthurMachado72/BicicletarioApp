package br.com.bicicletarioapp.controller;

import br.com.bicicletarioapp.model.Usuario;
import br.com.bicicletarioapp.service.UsuarioService;
import br.com.bicicletarioapp.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class LoginController {
    
    private UsuarioService usuarioService;
    private EntityManager em;
    
    public LoginController() {
        this.em = JPAUtil.getEntityManager();
        this.usuarioService = new UsuarioService(em);
    }
    
    /**
     * Método para autenticar usuário
     * @param nome Nome do usuário
     * @param senha Senha do usuário
     * @return true se autenticação for bem-sucedida, false caso contrário
     */
    public boolean autenticarUsuario(String nome, String senha) {
        try {
            Usuario usuario = usuarioService.autenticar(nome, senha);
            return usuario != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Método para cadastrar novo usuário
     * @param nome Nome do usuário
     * @param senha Senha do usuário
     * @return true se cadastro for bem-sucedido, false caso contrário
     */
    public boolean cadastrarUsuario(String nome, String senha) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setSenha(senha);
            return usuarioService.cadastrar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Fechar EntityManager quando não for mais necessário
     */
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
