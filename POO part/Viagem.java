import java.util.ArrayList;

public class Viagem {
    private int idViagem;
    private String origem = "Rodoviária RT";
    private String destino;
    private double preco;
    private Onibus onibus;
    private ArrayList<Bilhete> bilhetes;

    public Viagem(int idViagem, String destino, double preco, Onibus onibus) {
        this.idViagem = idViagem;
        this.destino = destino;
        this.preco = preco;
        this.onibus = onibus;
        onibus.adicionarViagem(this);
        this.bilhetes = new ArrayList<>();
    }

    public void registrarBilhete(Bilhete bilhete) {
        this.bilhetes.add(bilhete);
    }

    public String getDestino() {
        return destino;
    }

    public double getPreco() {
        return preco;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public String getDetalhes() {
        return origem + " -> " + destino;
    }

    public Onibus getOnibus() {
        return onibus;
    }
}