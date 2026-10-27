package br.com.audiflex;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAO {
    
    public void cadastrar(Produto produto) {

        String sql = "INSERT INTO produto (modelo, preco_tabela) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar()) {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, produto.getModelo());
            statement.setDouble(2, produto.getPrecoTabela());

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Produto cadastrado com sucesso.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public List<Produto> listar() {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (Connection conexao = Conexao.conectar()) {

            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {

                long id = resultado.getLong("id");
                String modelo = resultado.getString("modelo");
                double precoTabela = resultado.getDouble("preco_tabela");

                Produto produto = new Produto(id, modelo, precoTabela);

                produtos.add(produto);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return produtos;
    }
}
