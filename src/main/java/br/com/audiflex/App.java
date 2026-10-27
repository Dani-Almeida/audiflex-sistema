
package br.com.audiflex;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        try (Connection conexao = Conexao.conectar()) {
            System.out.println("Conexão com o banco realizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }

     
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listar();

        for (Produto produto : produtos) {
            System.out.println(
                produto.getId() + " - "
                + produto.getModelo() + " - R$ "
                + produto.getPrecoTabela());   
        }

        Scanner scanner = new Scanner(System.in);

                
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        System.out.println("Digite o email do cliente: ");
        String email = scanner.nextLine();

        System.out.println("Digite o CPF/CNPJ do cliente: ");
        String cpfCnpj = scanner.nextLine();

        
        
        Cliente cliente = new Cliente(
        nome, 
        telefone, 
        email, 
        cpfCnpj
        );

        Orcamento orcamento = new Orcamento(cliente);
        String continuar = "S";

        //SELEÇÃO DO PRODUTO
        while (continuar.equalsIgnoreCase("S")) {

            System.out.println("Digite o ID do produto desejado: ");
        long idProdutoEscolhido = scanner.nextLong();
        scanner.nextLine();

        Produto produtoEscolhido = null;

        for (Produto produto : produtos) {
            if (produto.getId() == idProdutoEscolhido) {
                produtoEscolhido = produto;
                break;
            }
        }

        if (produtoEscolhido == null) {
            System.out.println("Produto não encontrado.");
            scanner.close();
            return;
        }

        System.out.println("Produto selecionado: " + produtoEscolhido.getModelo());

        // LARGURA
        double largura = 0;

        while(largura <= 0){
            System.out.println("Digite a largura em metros (ex: 1,50): ");

            try { 
                largura = scanner.nextDouble();

                if (largura <= 0) {
                     System.out.println("A largura deve ser maior que zero.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }


        // ALTURA
        double altura = 0;

        while(altura <= 0){
            System.out.println("Digite a altura em metros (ex: 2,00): ");

            try { 
                altura = scanner.nextDouble();

                if (altura <= 0) {
                    System.out.println("A altura deve ser maior que zero.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }

        scanner.nextLine();

        // AMBIENTE
        System.out.println("Digite o ambiente: ");
        String ambiente = scanner.nextLine();

        // PERCENTUAL DE ACRÉSCIMO
        double percentualAcrescimo = 0;
        boolean percentualValido = false;

        while (!percentualValido) {
                System.out.println("Digite o percentual de acréscimo: ");

            try {
                percentualAcrescimo = scanner.nextDouble();

                if (percentualAcrescimo < 0) {
                    System.out.println("O percentual não pode ser negativo.");

                } else {
                    percentualValido = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }
        
        scanner.nextLine();

        // CRIAÇÃO DO ITEM
        ItemOrcamento item = new ItemOrcamento(largura, altura, percentualAcrescimo, ambiente, produtoEscolhido);

        System.out.println("Deseja adicionar um motor tubular? (S/N)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            Adicional motor = new Adicional("Motor tubular", 650);
            item.adicionarAdicional(motor);
}

        // ADICIONAR AO ORÇAMENTO
        orcamento.adicionarItem(item);

        System.out.println("Item adicionado ao orçamento.");

        // PERGUNTAR SE DESEJA CONTINUAR
        System.out.println("Deseja adicionar outra persiana? (S/N)");
        continuar =  scanner.nextLine();
        
        } // FIM DO WHILE PRINCIPAL
         
       
        System.out.println("\n--- RESUMO DO ORÇAMENTO ---");
        System.out.println("Cliente: " + orcamento.getCliente().getNome());
      
       
        for (ItemOrcamento item : orcamento.getItens()) {
            System.out.println("------------------------");
            System.out.println("Modelo: " + item.getModelo());
            System.out.println("Ambiente: " + item.getAmbiente());
            System.out.println("Área real: " + item.calcularAreaReal());
            System.out.println("Área cobrada: " + item.calcularAreaCobrada());
            System.out.println("Preço de venda/m²: " + item.calcularPrecoVendaM2());
            
           

            System.out.println("Adicionais: ");
            item.listarAdicionais();

            System.out.println("Total dos adicionais: R$ " + item.calcularTotalAdicionais());

            System.out.println("Valor do item: R$ " + item.calcularValorItem());
        }

        System.out.println("------------------------");
        System.out.println("Total do orçamento: R$ " + orcamento.calcularTotal());
         
        System.out.println("\n--- CLIENTE CADASTRADO ---");
        System.out.println("Nome: "+ cliente.getNome());
        System.out.println("Telefone: "+ cliente.getTelefone());
        System.out.println("Email: "+ cliente.getEmail());
        System.out.println("CPF/CNPJ: "+ cliente.getCpfCnpj());
        
        scanner.close();
    }

    
    
}    


