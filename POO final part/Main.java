
public class Main {
    public static void main(String[] args) {
        
        MotoristaDao mDao = new MotoristaDao();
        OnibusDao oDao = new OnibusDao();
        ViagemDao vDao = new ViagemDao();
        PassageiroDao pDao = new PassageiroDao();
        BilheteDao bDao = new BilheteDao();

        Motorista motorista = new Motorista(1, "Carlos Silva");
        mDao.adicionarM(motorista); 

        Onibus onibus = new Onibus("ABC-1234", motorista);
        oDao.adicionarO(onibus);

        Viagem viagem = new Viagem(100, "Rio de Janeiro", 150.50, onibus);
        vDao.adicionarV(viagem);

        Passageiro passageiro = new Passageiro(50, "Ana Souza");
        pDao.adicionarP(passageiro);

        Bilhete bilhete = new Bilhete(1000, viagem, passageiro);
        bDao.adicionarB(bilhete);

        ///*
        bDao.removerB(1000);
        pDao.removerP(50);
        vDao.removerV(100);
        oDao.removerO("ABC-1234");
        mDao.removerM(1);
        //*/
    }
}
