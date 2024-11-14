

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados {

    private static final String SQL_UPDATE = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";

    public void Atualizar() {
        // Conecta ao banco de dados
        try (Connection conexao = ConexaoBD.conectar(); // Garantir o fechamento da conexão automaticamente
             Scanner scanner = new Scanner(System.in)) {

            if (conexao != null) {
                // Solicita ao usuário o ID do aluno a ser atualizado
                System.out.print("Digite o ID do aluno que deseja atualizar: ");
                int id = obterNumero(scanner); // Função para obter número com validação

                // Solicita o novo nome do aluno
                System.out.print("Digite o novo nome do aluno: ");
                String nome = scanner.nextLine();

                // Solicita a nova idade do aluno
                System.out.print("Digite a nova idade do aluno: ");
                int idade = obterNumero(scanner); // Função para obter número com validação

                // Prepara a instrução de atualização
                try (PreparedStatement stmt = conexao.prepareStatement(SQL_UPDATE)) {
                    stmt.setString(1, nome);
                    stmt.setInt(2, idade);
                    stmt.setInt(3, id);

                    // Executa a atualização
                    int rowsUpdated = stmt.executeUpdate();

                    // Verifica se algum registro foi atualizado
                    if (rowsUpdated > 0) {
                        System.out.println("Registro atualizado com sucesso!");
                    } else {
                        System.out.println("Nenhum registro encontrado com o ID especificado.");
                    }
                } catch (SQLException e) {
                    System.err.println("Erro ao atualizar dados: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Função para obter um número do usuário com validação
    private static int obterNumero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next(); // Descarta a entrada inválida
        }
        return scanner.nextInt();
    }
}
