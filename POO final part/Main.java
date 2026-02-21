public class Main {
    public static void main(String[] args) {

        // Instanciação única dos DAOs
        MotoristaDao mDao = new MotoristaDao();
        OnibusDao oDao = new OnibusDao();
        ViagemDao vDao = new ViagemDao();
        PassageiroDao pDao = new PassageiroDao();
        BilheteDao bDao = new BilheteDao();

        System.out.println("etapa 1: inserção");
        // Criando e adicionando dados
        Motorista m1 = new Motorista(1, "Carlos Silva");
        mDao.adicionarM(m1);
        Onibus o1 = new Onibus("ABC-1234", m1);
        oDao.adicionarO(o1);
        Viagem v1 = new Viagem(100, "Rio de Janeiro", 150.00, o1);
        vDao.adicionarV(v1);
        Passageiro p1 = new Passageiro(50, "Ana Souza");
        pDao.adicionarP(p1);
        Bilhete b1 = new Bilhete(1000, v1, p1);
        bDao.adicionarB(b1);

        // Listagem (usa o toString automaticamente)
        System.out.println("listagem de motoristas: " + mDao.listarM());
        System.out.println("listagem de ônibus: " + oDao.listarO());
        System.out.println("listagem de viagens: " + vDao.listarV());
        System.out.println("listagem de passageiros: " + pDao.listarP());
        System.out.println("listagem de bilhetes: " + bDao.listarB());

        System.out.println("\netapa 2: update");
        m1 = new Motorista(1, "Carlos S");
        mDao.updateM(m1);
        System.out.println("listagem de motoristas atualizada: " + mDao.listarM());

        System.out.println("\netapa 3: delete");
        //bDao.removerB(1000);
        //pDao.removerP(50);
        //vDao.removerV(100);
        //oDao.removerO("ABC-1234");
        //mDao.removerM(1);

        // Listagem final para confirmar banco vazio []
        System.out.println("listagem final de motoristas: " + mDao.listarM());
        System.out.println("listagem final de bilhetes: " + bDao.listarB());
        System.out.println("\nFim do processo: Banco de dados limpo.");
    }
}
