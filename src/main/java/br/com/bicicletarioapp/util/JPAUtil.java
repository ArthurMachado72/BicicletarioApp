package br.com.bicicletarioapp.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "br.com.bicicletarioapp_BicicletarioApp_jar_1.0-SNAPSHOTPU";
    private static EntityManagerFactory emf;

    private JPAUtil() {
        // Construtor privado para evitar instanciação
    }

    public static synchronized EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}