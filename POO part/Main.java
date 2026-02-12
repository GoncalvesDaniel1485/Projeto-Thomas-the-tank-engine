
public class Main {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Viagens ---");

        // 1. Criar o Motorista
        Motorista mot = new Motorista(1, "Carlos Silva");

        // 2. Criar o Ônibus (precisa do Motorista)
        Onibus onibus = new Onibus("XYZ-9999", mot);

        // 3. Criar a Viagem (precisa do Ônibus)
        Viagem viagem = new Viagem(100, "São Paulo", "4h30", onibus);

        // 4. Criar o Passageiro
        Passageiro pass = new Passageiro(50, "Ana Souza", 28);

        // 5. Gerar o Bilhete (precisa da Viagem e do Passageiro)
        Bilhete bilhete = new Bilhete(1234, 85.90, "São Paulo", viagem, pass);

        // --- Testando as saídas ---
        System.out.println("\nResumo da Operação:");
        System.out.println("Motorista: " + onibus.getMotorista().getNome());
        System.out.println("Ônibus: " + onibus.getPlacaOnibus());
        System.out.println("Passageiro: " + pass.getNome());
        System.out.println("Viagem Destino: " + viagem.getDestino());
        System.out.println("Dados do Bilhete: " + bilhete.toString());
    }
}
