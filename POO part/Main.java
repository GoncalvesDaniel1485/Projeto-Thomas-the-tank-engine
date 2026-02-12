
public class Main {

    public static void main(String[] args) {
        // Criando a estrutura
        Motorista m1 = new Motorista(1, "Carlos");
        Onibus o1 = new Onibus("ABC-1234", m1);
        Viagem v1 = new Viagem(10, "São Paulo", "4h", o1);

        // Criando passageiros para a mesma viagem
        Passageiro p1 = new Passageiro(101, "Alice", 25);
        Passageiro p2 = new Passageiro(102, "Bob", 30);

        // Vendendo bilhetes (Sem precisar repetir o destino!)
        Bilhete b1 = new Bilhete(1, 150.0, v1, p1);
        Bilhete b2 = new Bilhete(2, 150.0, v1, p2);

        System.out.println("--- Sistema de Transporte ---");
        System.out.println("Viagem para: " + v1.getDestino());
        System.out.println("Passageiros confirmados: " + v1.getBilhetes().size());
        System.out.println("Detalhe do Passageiro 1: " + p1.getNome() + " - " + b1.toString());
        System.out.println("Detalhe do Passageiro 2: " + p2.getNome() + " - " + b2.toString());
    }
}
