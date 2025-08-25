package br.com.bicicletarioapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SecurityUtil {
    
    public static boolean checkSHA256(String inputPassword, String storedHash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(inputPassword.getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            return encoded.equals(storedHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Erro ao verificar senha: " + e.getMessage());
            return false;
        }
    }
}    
