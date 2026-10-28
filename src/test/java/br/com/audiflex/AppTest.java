package br.com.audiflex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void deveCalcularTotalComAcrescimoDe90PorCento() {

        Cliente cliente = new Cliente(
            "Cliente Teste",
            "123456789",
            "teste@exemplo.com",
            "12345678900"
        );

        Orcamento orcamento = new Orcamento(cliente);

        Produto produto = new Produto("Rolô", 150.0);

        ItemOrcamento item = new ItemOrcamento(
            2.0, 3.0, "Sala", produto
        );

        orcamento.adicionarItem(item);

        double totalFinal = orcamento.calcularTotalComAcrescimo(90);

        assertEquals(1710.0, totalFinal, 0.001);
    }

    @Test
    public void deveAplicarAcrescimoSobreAdicionais() {

        Cliente cliente = new Cliente(
            "Cliente Teste",
            "123456789",
            "teste@exemplo.com",
            "12345678900"
        );

        Orcamento orcamento = new Orcamento(cliente);

        Produto produto = new Produto("Rolô", 150.0);

        ItemOrcamento item = new ItemOrcamento(
            2.0, 3.0, "Sala", produto
        );

        item.adicionarAdicional(
            new Adicional("Motor tubular", 650.0)
        );

        orcamento.adicionarItem(item);

        double totalFinal = orcamento.calcularTotalComAcrescimo(90);

        assertEquals(2945.0, totalFinal, 0.001);
    }

    @Test
    public void deveAplicarAreaMinimaDe120() {

        Produto produto = new Produto("Rolô", 150.0);

        ItemOrcamento item = new ItemOrcamento(
            0.60, 1.00, "Quarto", produto
        );

        assertEquals(0.60, item.calcularAreaReal(), 0.001);

        assertEquals(1.20, item.calcularAreaCobrada(), 0.001);

        assertEquals(180.0, item.calcularValorItem(), 0.001);
    }

    @Test
    public void deveRejeitarLarguraIgualAZero() {

        Produto produto = new Produto("Rolô", 150.0);

        assertThrows(IllegalArgumentException.class, () -> {
            new ItemOrcamento(0.0, 2.0, "Sala", produto);
        });
    }

    @Test
    public void deveRejeitarAlturaNegativa() {

        Produto produto = new Produto("Rolô", 150.0);

        assertThrows(IllegalArgumentException.class, () -> {
            new ItemOrcamento(1.50, -2.0, "Sala", produto);
        });
    }
}
