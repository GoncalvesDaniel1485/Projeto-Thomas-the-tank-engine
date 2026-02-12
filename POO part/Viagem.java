
public class Viagem {

    private int idViagem;
    private int idPassagem;
    private String destino;
    private String tempo;

    // Relacionamento (1, 1): Viagem é feita por 1 ônibus
    private Onibus onibus;

    // Relacionamento (1, 1): Viagem refere-se a 1 bilhete
    private Bilhete bilhete;

    public Viagem(int idViagem, String destino, String tempo, Onibus onibus) {
        this.idViagem = idViagem;
        this.destino = destino;
        this.tempo = tempo;
        this.onibus = onibus;

        // Adiciona esta viagem à lista do ônibus automaticamente
        onibus.adicionarViagem(this);
    }

    // Setter para definir o bilhete depois (pois é uma dependência mútua)
    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    // Getters
    public int getIdViagem() {
        return idViagem;
    }

    public String getDestino() {
        return destino;
    }

    public String getTempo() {
        return tempo;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }
}
