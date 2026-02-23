import java.util.List;
import java.util.Scanner;

public class MenuViagem {

    private ViagemDao dao = new ViagemDao();

    public void executar(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU VIAGEM ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Atualizar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1: {
                    System.out.print("ID da viagem: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Destino: ");
                    String destino = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(sc.nextLine());

                    System.out.print("Placa do ônibus: ");
                    String placa = sc.nextLine();

                    // Criamos apenas o Onibus com a placa
                    Onibus onibus = new Onibus(placa, null);

                    Viagem viagem = new Viagem(id, destino, preco, onibus);

                    dao.adicionarV(viagem);
                }
                    break;

                case 2:
                    List<Viagem> lista = dao.listarV();

                    if (lista.isEmpty()) {
                        System.out.println("Nenhuma viagem cadastrada.");
                    } else {
                        for (Viagem v : lista) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID da viagem para remover: ");
                    int idRemover = Integer.parseInt(sc.nextLine());
                    dao.removerV(idRemover);
                    break;

                case 4: {
                    System.out.print("ID da viagem: ");
                    int idAtualizar = Integer.parseInt(sc.nextLine());

                    System.out.print("Novo destino: ");
                    String novoDestino = sc.nextLine();

                    System.out.print("Novo preço: ");
                    double novoPreco = Double.parseDouble(sc.nextLine());

                    dao.atualizarV(idAtualizar, novoDestino, novoPreco);
                }
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