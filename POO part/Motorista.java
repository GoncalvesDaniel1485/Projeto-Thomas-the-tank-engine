
import java.util.ArrayList;
import java.util.List;

public class Motorista {

    private int idMotorista;
    private String nome;
    // Relacionamento (0, n): Motorista conduz vários ônibus
    private List<Onibus> onibusConduzidos;

    public Motorista(int idMotorista, String nome) {
        this.idMotorista = idMotorista;
        this.nome = nome;
        this.onibusConduzidos = new ArrayList<>();
    }

    public void adicionarOnibus(Onibus onibus) {
        this.onibusConduzidos.add(onibus);
    }

    // Getters e Setters
    public int getIdMotorista() {
        return idMotorista;
    }

    public String getNome() {
        return nome;
    }

    public List<Onibus> getOnibusConduzidos() {
        return onibusConduzidos;
    }
}
