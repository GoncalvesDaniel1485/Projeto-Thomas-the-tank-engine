public class Passageiro {
    private int idPassageiro;
    private String nome;

    public Passageiro(int idPassageiro, String nome) {
        this.idPassageiro = idPassageiro;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getIdPassageiro() {
        return idPassageiro;
    }
    
    @Override
    public String toString() {
        return "Passageiro [ID: " + idPassageiro + ", Nome: " + nome + "]";
    }
}