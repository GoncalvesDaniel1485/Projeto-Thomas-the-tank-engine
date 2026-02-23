import java.util.List;
import java.util.Scanner;

public class MenuMotorista {

    private MotoristaDao dao = new MotoristaDao();

    public void executar(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU MOTORISTA ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    dao.adicionarM(new Motorista(id, nome));
                    break;

                case 2:
                    List<Motorista> lista = dao.listarM();
                    lista.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID do motorista: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    dao.updateM(new Motorista(idUpdate, novoNome));
                    break;

                case 4:
                    System.out.print("ID para deletar: ");
                    int idDelete = Integer.parseInt(sc.nextLine());

                    dao.removerM(idDelete);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}