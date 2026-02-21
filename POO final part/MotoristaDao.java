
import java.sql.*;

public class MotoristaDao {

    public void adicionarM(Motorista motorista) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("INSERT INTO motorista(id_motorista, nome) VALUES(?,?)");
            stmt.setInt(1, motorista.getIdMotorista());
            stmt.setString(2, motorista.getNome());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public void removerM(int idMotorista) {
    ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
    try (Connection conexao = postgres.getConection();
         PreparedStatement stmt = conexao.prepareStatement("DELETE FROM motorista WHERE id_motorista = ?")) {
        stmt.setInt(1, idMotorista);
        stmt.executeUpdate();
        System.out.println("Motorista removido.");
    } catch (SQLException e) { e.printStackTrace(); }
}

}
