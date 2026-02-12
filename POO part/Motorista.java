
import java.util.ArrayList;
import java.util.List;

public class Motorista {

    private int idMotorista;
    private String nome;
    private List<Onibus> onibusConduzidos = new ArrayList<>();

    public Motorista(int idMotorista, String nome) {
        this.idMotorista = idMotorista;
        this.nome = nome;
    }

    public void adicionarOnibus(Onibus onibus) {
        this.onibusConduzidos.add(onibus);
    }

    public String getNome() {
        return nome;
    }
}
