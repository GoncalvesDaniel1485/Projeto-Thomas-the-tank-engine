public class Bilhete {
    private int idBilhete;
    private double valorPago;
    private Viagem viagem;
    private Passageiro passageiro;

    public Bilhete(int idBilhete, Viagem viagem, Passageiro passageiro) {
        this.idBilhete = idBilhete;
        this.viagem = viagem;
        this.passageiro = passageiro;
        this.valorPago = viagem.getPreco();
    }

    public double getValorPago() {
        return valorPago;
    }

    public String toString() {
        return "Bilhete #" + idBilhete + " | Destino: " + viagem.getDestino() + " | Valor: R$" + valorPago;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public int getIdBilhete() {
        return idBilhete;
    }

    public Viagem getViagem() {
        return viagem;
    }
}