package br.com.bicicletarioapp.application;

import br.com.bicicletarioapp.repository.UsuarioRepository;
import br.com.bicicletarioapp.service.UsuarioService;
import br.com.bicicletarioapp.util.JPAUtil;
import br.com.bicicletarioapp.view.Login;
import jakarta.persistence.EntityManager;

public class BicicletarioApplication {

    public static void main(String[] args) {

        // Cria EntityManager
        EntityManager em = JPAUtil.getEntityManager();


        // Abre a tela de login
        java.awt.EventQueue.invokeLater(() -> {
            UsuarioService service = null;
            new Login(service).setVisible(true);
        });
    }
}