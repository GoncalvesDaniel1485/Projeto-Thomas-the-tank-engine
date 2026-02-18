import java.util.ArrayList;

public class Passageiro {
    private int idPassageiro;
    private String nome;
    private ArrayList<Bilhete> bilhetesComprados;

    public Passageiro(int idPassageiro, String nome) {
        this.idPassageiro = idPassageiro;
        this.nome = nome;
        this.bilhetesComprados = new ArrayList<>();
    }

    public void adicionarBilhete(Bilhete bilhete) {
        this.bilhetesComprados.add(bilhete);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Bilhete> getBilhetesComprados() {
        return bilhetesComprados;
    }

    public int getIdPassageiro() {
        return idPassageiro;
    }
}