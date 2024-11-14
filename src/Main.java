

import java.util.Scanner;

import scr.DeletarDados;
import scr.InserirDados;
import scr.LerDados;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InserirDados inserir = new InserirDados();
        DeletarDados deletar = new DeletarDados();
        AtualizarDados atualizar = new AtualizarDados();
        LerDados ler = new LerDados();
        int escolha;

        do {
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Inserir Aluno");
            System.out.println("2 - Atualizar Aluno");
            System.out.println("3 - Deletar Aluno");
            System.out.println("4 - Ler Registro de Aluno");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                   inserir.InserirDados();  // Chama a classe InserirDados
                    break;
                case 2:
                   atualizar.Atualizar();  // Chama a classe AtualizarDados
                    break;
                case 3:
                    deletar.DeletarDados();  // Chama a classe DeletarDados
                    break;
                case 4:
                    ler.LerDados();  // Chama a classe LerDados
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);

        scanner.close();
    }
}
