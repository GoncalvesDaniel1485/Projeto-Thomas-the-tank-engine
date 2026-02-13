public class Bilhete{

    private int idBilhete;
    private double valor;
    private Viagem viagem;
    private Passageiro passageiro;

    public Bilhete(int idBilhete, double valor, Viagem viagem, Passageiro passageiro){
        this.idBilhete = idBilhete;
        this.valor = valor;
        this.viagem = viagem;
        this.passageiro = passageiro;

        passageiro.adicionarBilhete(this);
        viagem.registrarBilhete(this);
    }

    public String getDestino(){
        return viagem.getDestino();
    }

    public String toString(){
        return "Bilhete #" + idBilhete + " | Destino: " + getDestino() + " | Valor: R$" + valor;
    }
}
