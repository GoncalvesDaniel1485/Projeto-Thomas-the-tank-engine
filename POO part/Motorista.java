import java.util.ArrayList;

public class Motorista{
    private int idMotorista;
    private String nome;
    private ArrayList<Onibus> onibusConduzidos;

public Motorista(int idMotorista, String nome){
    this.idMotorista = idMotorista;
    this.nome = nome;
    onibusConduzidos = new ArrayList<>();
    }

public void adicionarOnibus(Onibus onibus){
    this.onibusConduzidos.add(onibus);
    }

public String getNome(){
    return nome;
    }
}
