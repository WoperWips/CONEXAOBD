package scr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    // URL do banco de dados, substitua com o caminho do seu banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/aula_java_db"; // Altere "nome_do_banco" para o seu banco de dados
    private static final String USER = "root"; // Substitua "usuario" pelo seu nome de usuário do banco de dados
    private static final String PASSWORD = ""; // Substitua "senha" pela sua senha do banco de dados

    // Método para estabelecer a conexão com o banco de dados
    public static Connection conectar() {
        Connection conexao = null;
        try {
            // Tenta estabelecer a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }
}
