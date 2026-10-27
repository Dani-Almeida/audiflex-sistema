package br.com.audiflex;

public class Produto {

    private long id;
    private String modelo;
    private double precoTabela;
    

    public Produto(String modelo, double precoTabela) {
        this.modelo = modelo;
        this.precoTabela = precoTabela;
    }

    public Produto(long id, String modelo, double precoTabela) {
    this.id = id;
    this.modelo = modelo;
    this.precoTabela = precoTabela;
    }

     public long getId() {
        return this.id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getPrecoTabela() {
        return this.precoTabela;
    }
    
   
}
