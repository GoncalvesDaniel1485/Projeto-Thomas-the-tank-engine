
import java.util.List;
import java.util.Scanner;

public class MenuBilhete {

    private BilheteDao dao = new BilheteDao();

    public void executar(Scanner sc) {

        int opcao;

        do {
            System.out.println("\n--- MENU BILHETE ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Atualizar");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1: {
                    System.out.print("ID do bilhete: ");
                    int idBilhete = Integer.parseInt(sc.nextLine());

                    System.out.print("ID da viagem: ");
                    int idViagem = Integer.parseInt(sc.nextLine());

                    System.out.print("Destino da viagem: ");
                    String destino = sc.nextLine();

                    System.out.print("Preço da viagem: ");
                    double preco = Double.parseDouble(sc.nextLine());

                    System.out.print("ID do passageiro: ");
                    int idPassageiro = Integer.parseInt(sc.nextLine());

                    System.out.print("Nome do passageiro: ");
                    String nomePassageiro = sc.nextLine();

                    Viagem viagem = new Viagem(idViagem, destino, preco, null);
                    Passageiro passageiro = new Passageiro(idPassageiro, nomePassageiro);
                    Bilhete bilhete = new Bilhete(idBilhete, viagem, passageiro);

                    dao.adicionarB(bilhete);
                    System.out.println("Bilhete emitido com sucesso!");
                    break;
                }

                case 2: {
                    List<Bilhete> lista = dao.listarB();

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum bilhete encontrado.");
                    } else {
                        for (Bilhete b : lista) {
                            System.out.println(b);
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.print("Digite o ID do bilhete para remover: ");
                    int idRemover = Integer.parseInt(sc.nextLine());
                    dao.removerB(idRemover);
                    break;
                }

                case 4: {
                    System.out.print("ID do bilhete: ");
                    int idBilhete = Integer.parseInt(sc.nextLine());

                    System.out.print("Novo ID da viagem: ");
                    int novoIdViagem = Integer.parseInt(sc.nextLine());

                    System.out.print("Novo ID do passageiro: ");
                    int novoIdPassageiro = Integer.parseInt(sc.nextLine());

                    dao.atualizarB(idBilhete, novoIdViagem, novoIdPassageiro);
                    System.out.println("Bilhete atualizado com sucesso!");
                    break;
                }

                case 0: {
                    System.out.println("Voltando...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida.");
                }
            }

        } while (opcao != 0);
    }
}