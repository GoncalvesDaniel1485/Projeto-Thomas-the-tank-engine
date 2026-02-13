import java.util.ArrayList;

public class Viagem{

    private int idViagem;
    private String destino;
    private String tempo;
    private Onibus onibus;
    private ArrayList<Bilhete> bilhetes;

    public Viagem(int idViagem, String destino, String tempo, Onibus onibus){
        this.idViagem = idViagem;
        this.destino = destino;
        this.tempo = tempo;
        this.onibus = onibus;
        onibus.adicionarViagem(this);
        bilhetes = new ArrayList<>();
    }

    public void registrarBilhete(Bilhete bilhete){
        this.bilhetes.add(bilhete);
    }

    public String getDestino(){
        return destino;
    }

    public ArrayList<Bilhete> getBilhetes(){
        return bilhetes;
    }
}
