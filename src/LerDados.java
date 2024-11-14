package scr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LerDados {
    public void LerDados() {
        // Conecta ao banco de dados
        Connection conectar = ConexaoBD.conectar();
        Connection conexao = conectar;
        if (conexao != null) {
            String sql = "SELECT * FROM alunos";
            try {
                // Prepara e executa a consulta SQL
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                System.out.println("Registros da tabela 'alunos':");
                // Percorre os resultados e exibe cada registro
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");

                    System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
                }
            } catch (SQLException e) {
                System.err.println("Erro ao ler dados: " + e.getMessage());
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
