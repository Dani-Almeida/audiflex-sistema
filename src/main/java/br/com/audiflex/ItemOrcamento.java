package br.com.audiflex;

import java.util.ArrayList;
import java.util.List;

public class ItemOrcamento {

    private double largura;
    private double altura;
    private String ambiente;
    private Produto produto;
    private List<Adicional> adicionais;
    

    public ItemOrcamento (double largura, double altura, String ambiente, Produto produto){

        if (largura <= 0) {
            throw new IllegalArgumentException("A largura deve ser maior que zero.");
        }

        if (altura <= 0) {
            throw new IllegalArgumentException("A altura deve ser maior que zero.");
        }

        this.largura = largura;
        this.altura = altura;
        this.ambiente = ambiente;
        this.produto = produto;
        this.adicionais = new ArrayList<>();
        
    }

    public double calcularAreaReal() {
        return largura * altura;
    }

    public double calcularAreaCobrada() {

        double areaReal = calcularAreaReal();

        if (areaReal < 1.20){
            return 1.20;
        }else{
            return areaReal;
        }
    }

    public double calcularValorTabela() {
        return calcularAreaCobrada() * produto.getPrecoTabela();
    }

    public double getPrecoTabela() {
        return produto.getPrecoTabela();
    }

    public double calcularValorItem() {
        return calcularValorTabela() + calcularTotalAdicionais();
    }

    public void adicionarAdicional(Adicional adicional){
        this.adicionais.add(adicional);
    }

    public double calcularTotalAdicionais(){

        double total = 0;

        for (Adicional adicional : adicionais) {
            total += adicional.getValor();
        }
        return total;
    }

    public void listarAdicionais() {
        for (Adicional adicional : adicionais){
            System.out.println(adicional.getDescricao() + ": R$ " + adicional.getValor());
        }
    }

    public void removerAdicional(Adicional adicional) {
        this.adicionais.remove(adicional);
    }

    public String getAmbiente() {
        return this.ambiente;
    }

    public String getModelo() {
        return this.produto.getModelo();
    }
    
}
