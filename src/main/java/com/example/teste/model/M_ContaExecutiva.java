package com.example.teste.model;

public class M_ContaExecutiva extends M_ContaBancaria{
    private double limite;

    public M_ContaExecutiva(double limite) {
        this.limite = limite;
    }

    /**
     * Retorna o limite da conta executiva
     * @return
     */
    public double getLimite() {
        return limite;
    }

    /**
     * Retorna o saldo da conta mais o limite da conta
     * @return
     */
    @Override
    public double getSaldo(){
        return super.getSaldo()+this.getLimite();
    }

    /**
     * Saca {@code valor} da conta levando o limite em consideração
     * @param valor em R$ a ser sacado
     * @return saldo em R$ após o saque
     */
    @Override
    public double sacar(double valor){
        if(valor <= 0.0){
            throw new IllegalArgumentException("O valor do saque deve ser positivo e maior que zero (0.0)");
        };
        if(valor > getSaldo()){
            throw new IllegalArgumentException("O valor do saque deve ser menor ou igual que o saldo atual");
        };
        super.saldo -= valor;
        return getSaldo();
    }
}
