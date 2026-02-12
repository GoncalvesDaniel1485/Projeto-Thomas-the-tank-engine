
import java.util.ArrayList;
import java.util.List;

public class Onibus {

    private String placaOnibus;
    private Motorista motorista;
    private List<Viagem> viagens = new ArrayList<>();

    public Onibus(String placaOnibus, Motorista motorista) {
        this.placaOnibus = placaOnibus;
        this.motorista = motorista;
        motorista.adicionarOnibus(this);
    }

    public void adicionarViagem(Viagem viagem) {
        this.viagens.add(viagem);
    }

    public String getPlacaOnibus() {
        return placaOnibus;
    }
}
