public class Viagem {
    private int idViagem;
    private String origem = "Rodoviária RT";
    private String destino;
    private double preco;
    private Onibus onibus;

    public Viagem(int idViagem, String destino, double preco, Onibus onibus) {
        this.idViagem = idViagem;
        this.destino = destino;
        this.preco = preco;
        this.onibus = onibus;
    }

    public String getDestino() {
        return destino;
    }

    public double getPreco() {
        return preco;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public String getDetalhes() {
        return origem + " -> " + destino;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    @Override
    public String toString() {
        return "Viagem [ID: " + idViagem + " | " + getDetalhes() + " | Preço: R$" + preco + "]";
    }
}