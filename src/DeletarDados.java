package scr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados {
    public void DeletarDados() {
        // Conecta ao banco de dados
        Connection conexao = ConexaoBD.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM alunos WHERE id = ?";
            Scanner scanner = new Scanner(System.in);

            try {
                // Solicita ao usuário o ID do aluno a ser deletado
                System.out.print("Digite o ID do aluno que deseja deletar: ");
                int id = scanner.nextInt();

                // Prepara e executa a instrução de exclusão
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, id);
                int rowsDeleted = stmt.executeUpdate();

                // Verifica se algum registro foi deletado
                if (rowsDeleted > 0) {
                    System.out.println("Registro deletado com sucesso!");
                } else {
                    System.out.println("Nenhum registro encontrado com o ID especificado.");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao deletar dados: " + e.getMessage());
            } finally {
                try {
                    // Fecha a conexão com o banco de dados
                    if (conexao != null) conexao.close();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
                scanner.close();
            }
        }
    }
}
