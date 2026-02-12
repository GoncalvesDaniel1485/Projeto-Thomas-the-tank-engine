
import java.util.ArrayList;
import java.util.List;

public class Passageiro {

    private int idPassageiro;
    private String nome;
    private int idade;
    private List<Bilhete> bilhetesComprados = new ArrayList<>();

    public Passageiro(int idPassageiro, String nome, int idade) {
        this.idPassageiro = idPassageiro;
        this.nome = nome;
        this.idade = idade;
    }

    public void adicionarBilhete(Bilhete bilhete) {
        this.bilhetesComprados.add(bilhete);
    }

    public String getNome() {
        return nome;
    }
}
