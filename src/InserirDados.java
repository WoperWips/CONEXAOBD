package scr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDados {
    public void InserirDados() {
        // Conecta ao banco de dados
        Connection conexao = ConexaoBD.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
            try {
                // Prepara a instrução SQL
                PreparedStatement stmt = conexao.prepareStatement(sql);
                
                // Inserir primeiro registro
                stmt.setString(1, "João Silva");
                stmt.setInt(2, 20);
                stmt.executeUpdate();

                // Inserir segundo registro
                stmt.setString(1, "Maria Souza");
                stmt.setInt(2, 22);
                stmt.executeUpdate();

                // Inserir terceiro registro
                stmt.setString(1, "Pedro Santos");
                stmt.setInt(2, 25);
                stmt.executeUpdate();

                System.out.println("Dados inseridos com sucesso!");
                
                // Fecha o PreparedStatement
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
            } finally {
                try {
                    // Fecha a conexão com o banco de dados
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}
