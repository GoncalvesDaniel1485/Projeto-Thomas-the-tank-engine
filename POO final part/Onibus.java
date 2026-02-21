public class Onibus {

    private String placa_onibus;
    private Motorista motorista;

    public Onibus(String placa_onibus, Motorista motorista) {
        this.placa_onibus = placa_onibus;
        this.motorista = motorista;
    }

    public String getPlacaOnibus() {
        return placa_onibus;
    }

    public Motorista getMotorista() {
        return motorista;
    }
}
