package br.com.audiflex;

import java.util.List;
import java.util.ArrayList;

public class Orcamento {

    private Cliente cliente;
    private List<ItemOrcamento> itens;
    

    public Orcamento(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>(); 
    }

    public void adicionarItem(ItemOrcamento item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemOrcamento item : itens) {
            total += item.calcularValorItem();
        }
        return total;
    }

    public void removerItem(ItemOrcamento item) {
        this.itens.remove(item);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public List<ItemOrcamento> getItens() {
        return itens;
    }
    
}
