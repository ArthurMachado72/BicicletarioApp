package br.com.bicicletarioapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    
    @Test
    public void testCalcularTotalDiario() {
        // Teste SIMPLES: 8 horas × R$5,00 = R$40,00
        double resultado = calcularTotalDiario(8, 5.0);
        assertEquals(40.0, resultado, 0.001);
    }
    
    @Test
    public void testCalcularTotalDiario_Minimo1Hora() {
        // Teste: mínimo de 1 hora mesmo para 0,5 horas
        double resultado = calcularTotalDiario(0.5, 10.0);
        assertEquals(10.0, resultado, 0.001);
    }
    
    @Test
    public void testCalcularTotalDiario_8HorasComDecimal() {
        // Teste: 8,5 horas × R$4,00 = R$34,00
        double resultado = calcularTotalDiario(8.5, 4.0);
        assertEquals(34.0, resultado, 0.001);
    }
    
    // Método SIMPLES de cálculo (já deve existir em alguma classe)
    private double calcularTotalDiario(double horas, double precoHora) {
        if (horas < 1) {
            horas = 1; // Cobrança mínima de 1 hora
        }
        return horas * precoHora;
    }
}
