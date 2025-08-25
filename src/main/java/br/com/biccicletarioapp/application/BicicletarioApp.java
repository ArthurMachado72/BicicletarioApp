package br.com.biccicletarioapp.application;

import br.com.bicicletarioapp.model.Usuario;
import br.com.bicicletarioapp.view.Login;
import br.com.bicicletarioapp.repository.UsuarioRepository;
import br.com.bicicletarioapp.repository.impl.UsuarioRepositoryJPAImpl;
import br.com.bicicletarioapp.service.IUsuarioService;
import br.com.bicicletarioapp.service.UsuarioService;
import br.com.bicicletarioapp.service.impl.UsuarioServiceImpl;
import br.com.bicicletarioapp.util.JPAUtil;
import jakarta.persistence.EntityManager;

import javax.swing.SwingUtilities;

public class BicicletarioApp {

    EntityManager em = JPAUtil.getEntityManager();
    UsuarioRepository usuarioRepo = new UsuarioRepositoryJPAImpl(em) {
        @Override
        public Usuario findById(Long id) {
            return null;
        }
    };
    IUsuarioService usuarioService = new UsuarioServiceImpl(usuarioRepo);

    public static void main(String[] args) {
        // Configura o look and feel do sistema
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception ex) {
            System.err.println("Erro ao configurar look and feel: " + ex.getMessage());
        }

        // Inicializa EntityManager, Repository e Service
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioRepository repo = new UsuarioRepositoryJPAImpl(em) {
            @Override
            public Usuario findById(Long id) {
                return null;
           }
        };
        UsuarioService service = new UsuarioService((EntityManager) repo);
        // Abre a tela de login
        SwingUtilities.invokeLater(() -> {
            new Login(service).setVisible(true);
        });
    }
}
