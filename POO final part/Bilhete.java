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

    @Override
    public String toString() {
        return "Bilhete [ID: " + idBilhete + " | Passageiro: " + (passageiro != null ? passageiro.getNome() : "N/A")
                + " | Valor: R$" + valorPago + "]";
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