import com.example.teste.model.M_ContaExecutiva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ContaExecutivaTest {
    private M_ContaExecutiva conta;

    /**
     * Antes de todos os testes, recria a conta com R$1000.0 de limite e R$0.0 de saldo
     */
    @BeforeEach
    void recriarContaZero(){
        conta = new M_ContaExecutiva(1000.0);
    }

    /**
     * Testa se o limite está corretamente sendo somado ao saldo, totalizando o saldo total da conta executiva
     */
    @Test
    void saldoDeContaExecutiva(){
        assertEquals(1000.0, conta.getSaldo());
        assertEquals(1500.0, conta.depositar(500.0));
    }

    /**
     * Testa se ao sacar, leva o limite (1000.0) em consideração, já que o saldo é 0.0
     */
    @Test
    void sacarContaExecutiva(){
        assertEquals(500.0, conta.sacar(500.0));
    }

    @Test
    void sacarAlémDoLimite(){
        assertEquals(1000.0, conta.getLimite());
        assertEquals(0.0, conta.sacar(1000.0));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            double saldoTeste = conta.sacar(100.0);
        }, "O saque deveria dar erro ao tentar sacar além do limite");
        assertEquals("O valor do saque deve ser menor ou igual que o saldo atual", ex.getMessage(), "Mensagem de erro não é: \n \"O valor do saque deve ser menor ou igual que o saldo atual\"");
    }
}
