
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public List<Motorista> listarM() {
        List<Motorista> lista = new LinkedList<>();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM motorista ORDER BY id_motorista");
            rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Motorista(rs.getInt("id_motorista"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return lista;
    }

    public void updateM(Motorista motorista) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("UPDATE motorista SET nome=? WHERE id_motorista=?");
            stmt.setString(1, motorista.getNome());
            stmt.setInt(2, motorista.getIdMotorista());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
        }
    }
    
}
