import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassageiroDao {

    public void adicionarP(Passageiro passageiro) {
        // Usando o seu modelo de conexão
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = postgres.getConection();
            // SQL focado apenas nos atributos básicos da classe
            String sql = "INSERT INTO Passageiro (id_passageiro, nome) VALUES (?, ?)";
            
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, passageiro.getIdPassageiro());
            stmt.setString(2, passageiro.getNome());

            stmt.executeUpdate();
            System.out.println("Passageiro " + passageiro.getNome() + " adicionado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Utilizando o seu método de fechar que você mencionou no início
            postgres.close(stmt, conexao);
        }
    }

    public void removerP(int idPassageiro) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        try (Connection conexao = postgres.getConection();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM Passageiro WHERE id_passageiro = ?")) {
            stmt.setInt(1, idPassageiro);
            stmt.executeUpdate();
            System.out.println("Passageiro removido.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
}