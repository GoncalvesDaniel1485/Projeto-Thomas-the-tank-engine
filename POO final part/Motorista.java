

public class Motorista {

    private int idMotorista;
    private String nome;

    public Motorista(int idMotorista, String nome) {
        this.idMotorista = idMotorista;
        this.nome = nome;
    }

    // Este método é essencial para o Cadastro.java conseguir salvar no Postgres
    public int getIdMotorista() {
        return idMotorista;
    }

    // Este método é essencial para exibir o nome no relatório
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Motorista [ID: " + idMotorista + ", Nome: " + nome + "]";
    }

}
