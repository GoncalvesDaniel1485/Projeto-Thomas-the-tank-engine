
import java.util.ArrayList;
import java.util.List;

public class Viagem {

    private int idViagem;
    private String destino;
    private String tempo;
    private Onibus onibus;
    // Uma viagem agora tem uma lista de bilhetes (vários passageiros no ônibus)
    private List<Bilhete> bilhetes = new ArrayList<>();

    public Viagem(int idViagem, String destino, String tempo, Onibus onibus) {
        this.idViagem = idViagem;
        this.destino = destino;
        this.tempo = tempo;
        this.onibus = onibus;
        onibus.adicionarViagem(this);
    }

    public void registrarBilhete(Bilhete bilhete) {
        this.bilhetes.add(bilhete);
    }

    public String getDestino() {
        return destino;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }
}

