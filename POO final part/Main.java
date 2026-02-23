import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuMotorista menuMotorista = new MenuMotorista();
        MenuOnibus menuOnibus = new MenuOnibus();
        MenuViagem menuViagem = new MenuViagem();
        MenuPassageiro menuPassageiro = new MenuPassageiro();
        MenuBilhete menuBilhete = new MenuBilhete();

        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Motoristas");
            System.out.println("2 - Ônibus");
            System.out.println("3 - Viagens");
            System.out.println("4 - Passageiros");
            System.out.println("5 - Bilhetes");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    menuMotorista.executar(sc);
                    break;
                case 2:
                    menuOnibus.executar(sc);
                    break;
                case 3:
                    menuViagem.executar(sc);
                    break;
                case 4:
                    menuPassageiro.executar(sc);
                    break;
                case 5:
                    menuBilhete.executar(sc);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}