import java.util.ArrayList;

public class Onibus{
    private String placaOnibus;
    private Motorista motorista;
    private ArrayList<Viagem> viagens;

public Onibus(String placaOnibus, Motorista motorista){
    this.placaOnibus = placaOnibus;
    this.motorista = motorista;
    motorista.adicionarOnibus(this);
    viagens = new ArrayList<>();
    }

public void adicionarViagem(Viagem viagem){
    this.viagens.add(viagem);
    }

public String getPlacaOnibus(){
    return placaOnibus;
    }
}
