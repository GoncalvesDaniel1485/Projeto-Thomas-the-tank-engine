
import java.util.ArrayList;
import java.util.List;

public class Passageiro {

    private int idPassageiro;
    private String nome;
    private int idade;
    // Relacionamento (0, n): Passageiro compra vários bilhetes
    private List<Bilhete> bilhetesComprados;

    public Passageiro(int idPassageiro, String nome, int idade) {
        this.idPassageiro = idPassageiro;
        this.nome = nome;
        this.idade = idade;
        this.bilhetesComprados = new ArrayList<>();
    }

    public void comprarBilhete(Bilhete bilhete) {
        this.bilhetesComprados.add(bilhete);
    }

    // Getters
    public int getIdPassageiro() {
        return idPassageiro;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public List<Bilhete> getBilhetesComprados() {
        return bilhetesComprados;
    }
}
