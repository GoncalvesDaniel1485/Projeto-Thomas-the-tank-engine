
public class Bilhete {

    private int idBilhete;
    private double valor;
    private Viagem viagem;
    private Passageiro passageiro;

    public Bilhete(int idBilhete, double valor, Viagem viagem, Passageiro passageiro) {
        this.idBilhete = idBilhete;
        this.valor = valor;
        this.viagem = viagem;
        this.passageiro = passageiro;

        // Vincula o bilhete ao passageiro e à viagem automaticamente
        passageiro.adicionarBilhete(this);
        viagem.registrarBilhete(this);
    }

    // Método que busca o destino "emprestado" da viagem (evita redundância)
    public String getDestino() {
        return viagem.getDestino();
    }

    @Override
    public String toString() {
        return "Bilhete #" + idBilhete + " | Destino: " + getDestino() + " | Valor: R$" + valor;
    }
}
