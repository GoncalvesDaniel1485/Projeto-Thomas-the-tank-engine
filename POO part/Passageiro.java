import java.util.ArrayList;

public class Passageiro{
    private int idPassageiro;
    private String nome;
    private int idade;
    private ArrayList<Bilhete> bilhetesComprados;

    public Passageiro(int idPassageiro, String nome, int idade){
        this.idPassageiro = idPassageiro;
        this.nome = nome;
        this.idade = idade;
        bilhetesComprados = new ArrayList<>();
    }

    public void adicionarBilhete(Bilhete bilhete){
        this.bilhetesComprados.add(bilhete);
    }

    public String getNome(){
        return nome;
    }
}
