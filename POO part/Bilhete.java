
public class Bilhete {

    private int idBilhete;
    private double valor;
    private String destino;

    // Relacionamento (1, 1): Bilhete pertence a 1 Viagem
    private Viagem viagem;

    // Relacionamento (1, 1): Bilhete pertence a 1 Passageiro
    private Passageiro passageiro;

    public Bilhete(int idBilhete, double valor, String destino, Viagem viagem, Passageiro passageiro) {
        this.idBilhete = idBilhete;
        this.valor = valor;
        this.destino = destino;
        this.viagem = viagem;
        this.passageiro = passageiro;

        // Atualiza as listas nas outras classes
        passageiro.comprarBilhete(this);
        viagem.setBilhete(this);
    }

    // Getters
    public int getIdBilhete() {
        return idBilhete;
    }

    public double getValor() {
        return valor;
    }

    public String getDestino() {
        return destino;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    @Override
    public String toString() {
        return "Bilhete #" + idBilhete + " | Destino: " + destino + " | Valor: R$" + valor;
    }
}
