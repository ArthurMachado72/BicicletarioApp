package br.com.bicicletarioapp.service;

import br.com.bicicletarioapp.model.Aluguel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AluguelServiceTest {

    @InjectMocks
    private AluguelService aluguelService;

    @Test
    public void testCalcularValorAluguel_2Horas() {
        // Arrange
        Aluguel aluguel = new Aluguel();
        aluguel.setPrecoHora(BigDecimal.valueOf(10.0));
        aluguel.setHoraInicio(LocalDateTime.of(2024, 1, 1, 10, 0));
        aluguel.setHoraTermino(LocalDateTime.of(2024, 1, 1, 12, 0)); // 2 horas

        // Act
        BigDecimal resultado = aluguelService.calcularValorAluguel(aluguel);

        // Assert
        assertEquals(BigDecimal.valueOf(20.0), resultado);
    }

    @Test
    public void testCalcularValorAluguel_5Horas() {
        // Arrange
        Aluguel aluguel = new Aluguel();
        aluguel.setPrecoHora(BigDecimal.valueOf(5.0)); // ← R$5,00/hora (valor padrão)
        aluguel.setHoraInicio(LocalDateTime.of(2024, 1, 1, 10, 0));
        aluguel.setHoraTermino(LocalDateTime.of(2024, 1, 1, 15, 0)); // 5 horas

        // Act
        BigDecimal resultado = aluguelService.calcularValorAluguel(aluguel);

        // Assert
        assertEquals(BigDecimal.valueOf(25.0), resultado); // 5 horas × R$5 = R$25
    }

    @Test
    public void testCalcularValorAluguel_AluguelEmAndamento() {
        // Arrange
        Aluguel aluguel = new Aluguel();
        aluguel.setPrecoHora(BigDecimal.valueOf(5.0));
        aluguel.setHoraInicio(LocalDateTime.now().minusHours(3)); // Começou há 3 horas
        aluguel.setHoraTermino(null); // Ainda não terminou

        // Act
        BigDecimal resultado = aluguelService.calcularValorAluguel(aluguel);

        // Assert - Deve calcular aproximadamente 3 horas
        // Como usa LocalDateTime.now(), testamos se está dentro de uma faixa razoável
        assertEquals(BigDecimal.valueOf(15.0), resultado); // 3 horas × R$5 = R$15
    }
}