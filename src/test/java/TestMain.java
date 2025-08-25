package br.com.bicicletarioapp.test;

import br.com.bicicletarioapp.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestMain {
    
    public static void main(String[] args) {
        System.out.println("=== TESTANDO CONEXÃO COM BANCO ===");
        
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            System.out.println("✅ Conexão com banco estabelecida com sucesso!");
            
            // Teste simples de consulta
            Long count = em.createQuery("SELECT COUNT(c) FROM Cliente c", Long.class)
                         .getSingleResult();
            System.out.println("✅ Total de clientes no banco: " + count);
            
        } catch (Exception e) {
            System.err.println("❌ Erro na conexão: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        
        System.out.println("=== TESTE FINALIZADO ===");
    }
}
