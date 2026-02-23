import java.util.List;
import java.util.Scanner;

public class MenuPassageiro {

    private PassageiroDao dao = new PassageiroDao();

    public void executar(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU PASSAGEIRO ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Atualizar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1:
                    System.out.print("ID do passageiro: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nome do passageiro: ");
                    String nome = sc.nextLine();

                    Passageiro passageiro = new Passageiro(id, nome);
                    dao.adicionarP(passageiro);
                    break;

                case 2:
                    List<Passageiro> lista = dao.listarP();

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum passageiro cadastrado.");
                    } else {
                        for (Passageiro p : lista) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do passageiro para remover: ");
                    int idRemover = Integer.parseInt(sc.nextLine());
                    dao.removerP(idRemover);
                    break;

                case 4:
                    System.out.print("ID do passageiro: ");
                    int idAtualizar = Integer.parseInt(sc.nextLine());

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    dao.atualizarP(idAtualizar, novoNome);
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