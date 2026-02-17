import java.util.ArrayList;

public class Onibus {
    private String placaOnibus;
    private Motorista motorista;
    private ArrayList<Viagem> viagens;

    public Onibus(String placaOnibus, Motorista motorista) {
        this.placaOnibus = placaOnibus;
        this.motorista = motorista;
        this.viagens = new ArrayList<>();
        motorista.adicionarOnibus(this);
    }

    public void adicionarViagem(Viagem viagem) {
        this.viagens.add(viagem);
    }

    public String getPlacaOnibus() {
        return placaOnibus;
    }

    public Motorista getMotorista() {
        return motorista;
    }
}