import java.util.ArrayList;

public class Onibus {
    private String placa_onibus;
    private Motorista motorista;
    private ArrayList<Viagem> viagens;

    public Onibus(String placa_onibus, Motorista motorista) {
        this.placa_onibus = placa_onibus;
        this.motorista = motorista;
        this.viagens = new ArrayList<>();
        motorista.adicionarOnibus(this);
    }

    public void adicionarViagem(Viagem viagem) {
        this.viagens.add(viagem);
    }

    public String getPlacaOnibus() {
        return placa_onibus;
    }

    public Motorista getMotorista() {
        return motorista;
    }
}