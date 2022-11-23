package aplicativos;


import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import aplicativos.Registro.Pessoa;
import aplicativos.Registro.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 2;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        Piloto piloto = new Piloto();
        

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                    else{
                    System.out.println("\nDigite o nome do piloto: ");
                    pilotos[qtdCadastrados] = piloto;
                    piloto.setNome(in.nextLine());
                    System.out.println("\nE o cpf: ");
                    piloto.setCpf(in.nextLine());
                    System.out.println("\nAgora, digite o breve do piloto: ");
                    piloto.setBreve(in.nextLine());
                    System.out.println("\nNúmero da matricula: ");
                    piloto.setMatricula(in.nextInt());
                    in.nextLine();        
                    qtdCadastrados++;
                    
                }
                //Cadastre seu piloto aqui

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }
                
                for(int i = 0; i < qtdCadastrados; i++){
                    /*System.out.println(pilotos[qtdCadastrados]);*/
                    System.out.printf("Nome: %s \n", piloto.getNome());
                    System.out.printf("Cpf: %s \n", piloto.getCpf());
                    System.out.printf("Breve: %s \n", piloto.getBreve());
                    System.out.printf("Matricula: %d \n", piloto.getMatricula());
                }
                

                // Exiba os pilotos aqui

                voltarMenu(in);
            } else if (opcao == 3) {

            } else if (opcao == 4) {
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void setMatricula(int nextInt) {
    }

    private static void setBreve(String nextLine) {
    }

    private static void setCpf(String nextLine) {
    }

    private static void setNome(String nextLine) {
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
