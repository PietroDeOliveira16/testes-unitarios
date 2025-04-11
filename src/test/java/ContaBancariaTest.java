import com.example.teste.model.M_ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {
    private M_ContaBancaria conta;

    /**
     * Testa se consegue criar a conta
     */
    @BeforeEach
    void zerarConta(){
        conta = new M_ContaBancaria();
    }

    /**
     * Testa se o objeto foi criado (not null)
     */
    @Test
    void criarConta(){
        assertNotNull(conta, "Conta recém criada não deveria ser null");
    }

    /**
     * Testa se o saldo da conta começa em zero
     */
    @Test
    void saldoZero(){
        assertEquals(0.0, conta.getSaldo(), "Saldo inicial deveria ser 0.0");
    }

    /**
     * Testa se é possivel depositar corretamente na conta
     */
    @Test
    void depositar(){
        double saldo = conta.depositar(100.0);
        assertEquals(100.0, saldo, "O saldo deveria ser 100 após o depósito");
        assertEquals(saldo, conta.getSaldo(),"O retorno de depositar() deveria ser igual a 100");
        saldo = conta.depositar(100.0);
        assertEquals(200.0, saldo, "O saldo deveria ser 200 após dois depósitos de 100");
        assertEquals(200.0, conta.getSaldo(), "Saldo deveria ser igual a getSaldo() após dois depósitos");
    }

    /**
     * Testa se explode quando deposita negativo
     */
    @Test
    void depositarNegativo(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            double saldo = conta.depositar(-100.0);
        }, "O depósito deveria dar erro ao receber um valor negativo");
        assertEquals("Valor do depósito deve sempre ser positivo", ex.getMessage(), "Mensagem de erro não é: \n \"Erro: Valor do depósito deve sempre ser positivo\"");
    }

    /**
     * Testa se o saque reduz corretamente o saldo da conta e devolve o saldo atual após o saque
     */
    @Test
    void sacarValorValido(){
        conta.depositar(200.0);
        double saldo = conta.sacar(150.0);
        assertEquals(50.0, saldo, "saldo deveria ser 50.0 após depositar 200.0 e sacar 150.0");
        assertEquals(50.0, conta.getSaldo(), "getSaldo() deveria ser 50.0 depois de depositar 200.0 e sacar 150.0");
    }
}
