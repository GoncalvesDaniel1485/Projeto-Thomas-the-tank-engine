import java.util.List;
import java.util.Scanner;

public class MenuOnibus {

    private OnibusDao dao = new OnibusDao();

    public void executar(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU ÔNIBUS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Atualizar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("Placa do ônibus: ");
                    String placa = sc.nextLine();

                    System.out.print("ID do motorista: ");
                    int idMotorista = Integer.parseInt(sc.nextLine());

                    Motorista motorista = new Motorista(idMotorista, null);
                    Onibus onibus = new Onibus(placa, motorista);

                    dao.adicionarO(onibus);
                    break;

                case 2:
                    List<Onibus> lista = dao.listarO();

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum ônibus encontrado.");
                    } else {
                        for (Onibus o : lista) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite a placa do ônibus para remover: ");
                    String placaRemover = sc.nextLine();
                    dao.removerO(placaRemover);
                    break;

                case 4:
                    System.out.print("Placa atual do ônibus: ");
                    String placaAntiga = sc.nextLine();

                    System.out.print("Nova placa: ");
                    String novaPlaca = sc.nextLine();

                    System.out.print("ID Atual do motorista: ");
                    int novoIdMotorista = Integer.parseInt(sc.nextLine());

                    dao.atualizarO(placaAntiga, novaPlaca, novoIdMotorista);
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}