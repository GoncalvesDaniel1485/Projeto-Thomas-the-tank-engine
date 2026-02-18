import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Cadastro sistema = new Cadastro();

        Motorista m1 = new Motorista(1, "Carlos");
        Onibus o1 = new Onibus("ABC-1234", m1);

        Motorista m2 = new Motorista(2, "Ronaldo");
        Onibus o2 = new Onibus("COC-2002", m2);

        Motorista m3 = new Motorista(3, "Ronaldinho");
        Onibus o3 = new Onibus("BRU-X000", m3);

        sistema.adicionarMotorista(m1);
        sistema.adicionarMotorista(m2);
        sistema.adicionarMotorista(m3);

        sistema.adicionarOnibus(o1);
        sistema.adicionarOnibus(o2);
        sistema.adicionarOnibus(o3);

        Viagem v1 = new Viagem(10, "São Paulo", 150.00, o1);
        sistema.adicionarViagem(v1);

        Viagem v2 = new Viagem(15, "Rio Grande da Morte", 230.00, o2);
        sistema.adicionarViagem(v2);

        Viagem v3 = new Viagem(16, "Pinto Arriba", 40.00, o3);
        sistema.adicionarViagem(v3);

        Passageiro p1 = new Passageiro(101, "Alice");
        Passageiro p2 = new Passageiro(102, "Bob");
        sistema.adicionarPassageiro(p1);
        sistema.adicionarPassageiro(p2);

        Passageiro p3 = new Passageiro(103, "Fernanda");
        Passageiro p4 = new Passageiro(104, "Bartolomeu");
        sistema.adicionarPassageiro(p3);
        sistema.adicionarPassageiro(p4);

        Bilhete b1 = new Bilhete(1, v1, p1);
        Bilhete b2 = new Bilhete(2, v1, p2);

        Bilhete b3 = new Bilhete(3, v2, p3);
        Bilhete b4 = new Bilhete(4, v2, p4);

        sistema.adicionarBilhete(b1);
        sistema.adicionarBilhete(b2);

        sistema.adicionarBilhete(b3);
        sistema.adicionarBilhete(b4);

        try {
            Connection teste = Conexao.getConexao();
            System.out.println("Conexão com o Banco RT estabelecida com sucesso!");
            teste.close();
        } catch (SQLException e) {
            System.err.println("Falha ao conectar no PostgreSQL: " + e.getMessage());
            return; // Para o programa se não houver conexão
        }
    }

}