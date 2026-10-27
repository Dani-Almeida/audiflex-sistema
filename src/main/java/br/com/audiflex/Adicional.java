package br.com.audiflex;

public class Adicional {

    private String descricao;
    private double valor;
    

    public Adicional (String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValor() {
        return this.valor;
    }
}
