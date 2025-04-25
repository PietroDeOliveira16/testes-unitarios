package com.example.teste.model;

import java.math.BigDecimal;

public class M_ContaBancaria {
    protected double saldo;

    public M_ContaBancaria() {
        this.saldo = 0.0;
    }

    /**
     * Retorna o saldo
     * @return double
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Saca {@code valor} da conta
     * @param valor em R$ a ser sacado
     * @return saldo depois do saque
     */
    public double sacar(double valor){
        if(valor <= 0.0){
            throw new IllegalArgumentException("O valor do saque deve ser positivo e maior que zero (0.0)");
        };
        if(valor > saldo){
            throw new IllegalArgumentException("O valor do saque deve ser menor ou igual que o saldo atual");
        };
        this.saldo -= valor;
        return getSaldo();
    }

    /**
     * Deposita {@code valor} na conta
     * @param valor em R$ a ser depositado
     * @return saldo depois do depósito
     */
    public double depositar(double valor){
        if(valor < 0.0){
            throw new IllegalArgumentException("Valor do depósito deve sempre ser positivo");
        };
        this.saldo += valor;
        return getSaldo();
    }
}
