import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OnibusDao {
    
    public void adicionarO(Onibus onibus) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();

            String sql = "INSERT INTO Onibus (placa_onibus, id_motorista) VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, onibus.getPlacaOnibus());
            stmt.setInt(2, onibus.getMotorista().getIdMotorista());
            stmt.executeUpdate();
            System.out.println("Ônibus inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public void removerO(String placa) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        try (Connection conexao = postgres.getConection();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM Onibus WHERE placa_onibus = ?")) {
            stmt.setString(1, placa);
            stmt.executeUpdate();
            System.out.println("Ônibus removido.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
