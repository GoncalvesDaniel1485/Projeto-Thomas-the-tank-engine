import java.util.ArrayList;

public class Cadastro {
    private ArrayList<Motorista> motoristas = new ArrayList<>();
    private ArrayList<Onibus> onibus = new ArrayList<>();
    private ArrayList<Passageiro> passageiros = new ArrayList<>();
    private ArrayList<Viagem> viagens = new ArrayList<>();
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    public void adicionarMotorista(Motorista m) {
        motoristas.add(m);
    }

    public void adicionarOnibus(Onibus o) {
        onibus.add(o);
    }

    public void adicionarPassageiro(Passageiro p) {
        passageiros.add(p);
    }

    public void adicionarViagem(Viagem v) {
        viagens.add(v);
    }

    public void adicionarBilhete(Bilhete b) {
        bilhetes.add(b);
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void exibirRelatorioPassageiros(Viagem v) {
        if (v.getBilhetes().isEmpty()) {
            System.out.println("Nenhum passageiro embarcado.");
        } else {
            for (Bilhete b : v.getBilhetes()) {
                // Acessa o passageiro através do bilhete
                System.out.println("- " + b.getPassageiro().getNome() + " (Bilhete #" + b.toString() + ")");
            }
        }
    }

    public void exibirDetalhesRota(Viagem v) {
        System.out.println("--- DETALHES DA ROTA ---");
        System.out.println("ID da Viagem: " + v.getIdViagem());
        System.out.println("Itinerário: " + v.getDetalhes());
        System.out.println("Destino Final: " + v.getDestino());
    }

    public void exibirDetalhesTransporte(Viagem v) {
        Onibus o = v.getOnibus(); // Requer getter em Viagem.java
        Motorista m = o.getMotorista(); // Requer getter em Onibus.java
        System.out.println("--- DETALHES DO TRANSPORTE ---");
        System.out.println("Placa do Ônibus: " + o.getPlacaOnibus());
        System.out.println("Motorista: " + m.getNome());
    }

    public void exibirFinanceiroViagem(Viagem v) {
        double total = 0;
        for (Bilhete b : v.getBilhetes()) {
            total += b.getValorPago();
        }
        System.out.println("--- FINANCEIRO ---");
        System.out.println("Preço Unitário: R$ " + v.getPreco());
        System.out.println("Total Arrecadado: R$ " + total);
    }
}