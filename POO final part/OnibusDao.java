import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OnibusDao {

    public void adicionarO(Onibus onibus) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;

        try {
            conexao = postgres.getConection();
            if (onibus.getMotorista() == null) {
                System.out.println("Motorista não pode ser null.");
                return;
            }
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Onibus> listarO() {
        List<Onibus> lista = new LinkedList<>();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            // Fazemos um JOIN para pegar o nome do motorista também
            stmt = conexao.prepareStatement(
                    "SELECT o.*, m.nome FROM Onibus o INNER JOIN motorista m ON o.id_motorista = m.id_motorista");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Motorista m = new Motorista(rs.getInt("id_motorista"), rs.getString("nome"));
                lista.add(new Onibus(rs.getString("placa_onibus"), m));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return lista;
    }

    public void atualizarO(String placaAntiga, String novaPlaca, int novoMotoristaId) {

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();

        String sql = "UPDATE Onibus SET placa_onibus = ?, id_motorista = ? WHERE placa_onibus = ?";

        try (Connection conexao = postgres.getConection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novaPlaca);
            stmt.setInt(2, novoMotoristaId);
            stmt.setString(3, placaAntiga);

            stmt.executeUpdate();
            System.out.println("Ônibus atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}