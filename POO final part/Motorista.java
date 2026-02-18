import java.util.ArrayList;

public class Motorista {
    private int idMotorista;
    private String nome;
    private ArrayList<Onibus> onibusConduzidos;

    public Motorista(int idMotorista, String nome) {
        this.idMotorista = idMotorista;
        this.nome = nome;
        this.onibusConduzidos = new ArrayList<>();
    }

    // Este método é essencial para o Cadastro.java conseguir salvar no Postgres
    public int getIdMotorista() {
        return idMotorista;
    }

    // Este método é essencial para exibir o nome no relatório
    public String getNome() {
        return nome;
    }

    public void adicionarOnibus(Onibus onibus) {
        this.onibusConduzidos.add(onibus);
    }

    public ArrayList<Onibus> getOnibusConduzidos() {
        return onibusConduzidos;
    }
}