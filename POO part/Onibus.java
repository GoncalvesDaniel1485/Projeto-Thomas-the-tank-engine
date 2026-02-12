
import java.util.ArrayList;
import java.util.List;

public class Onibus {

    private String placaOnibus;
    // Relacionamento (1, 1): Ônibus tem 1 motorista
    private Motorista motorista;
    // Relacionamento (0, n): Ônibus faz várias viagens
    private List<Viagem> viagens;

    public Onibus(String placaOnibus, Motorista motorista) {
        this.placaOnibus = placaOnibus;
        this.motorista = motorista;
        this.viagens = new ArrayList<>();

        // Garante a consistência bidirecional
        motorista.adicionarOnibus(this);
    }

    public void adicionarViagem(Viagem viagem) {
        this.viagens.add(viagem);
    }

    // Getters e Setters
    public String getPlacaOnibus() {
        return placaOnibus;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }
}
