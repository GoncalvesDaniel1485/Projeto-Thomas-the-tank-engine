import java.util.ArrayList;

public class Cadastro {

    private ArrayList<Motorista> motoristas = new ArrayList<>();
    private ArrayList<Onibus> onibus = new ArrayList<>();
    private ArrayList<Passageiro> passageiros = new ArrayList<>();
    private ArrayList<Viagem> viagens = new ArrayList<>();
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    // MÉTODOS DE ADIÇÃO

    public void adicionarMotorista(Motorista m){
        motoristas.add(m);
    }

    public void adicionarOnibus(Onibus o){
        onibus.add(o);
    }

    public void adicionarPassageiro(Passageiro p){
        passageiros.add(p);
    }

    public void adicionarViagem(Viagem v){
        viagens.add(v);
    }

    public void adicionarBilhete(Bilhete b){
        bilhetes.add(b);
    }


    public ArrayList<Motorista> getMotoristas(){
        return motoristas;
    }

    public ArrayList<Onibus> getOnibus(){
        return onibus;
    }

    public ArrayList<Passageiro> getPassageiros(){
        return passageiros;
    }

    public ArrayList<Viagem> getViagens(){
        return viagens;
    }

    public ArrayList<Bilhete> getBilhetes(){
        return bilhetes;
    }
}
