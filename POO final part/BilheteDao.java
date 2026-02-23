import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BilheteDao {

    public void adicionarB(Bilhete bilhete) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            // Note que no SQL usamos as colunas de ID
            String sql = "INSERT INTO Bilhete(idBilhete, valorPago, id_viagem, id_passageiro) VALUES(?,?,?,?)";
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, bilhete.getIdBilhete());
            stmt.setDouble(2, bilhete.getValorPago());
            stmt.setInt(3, bilhete.getViagem().getIdViagem());
            stmt.setInt(4, bilhete.getPassageiro().getIdPassageiro());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public void removerB(int idBilhete) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        try (Connection conexao = postgres.getConection();
                PreparedStatement stmt = conexao.prepareStatement("DELETE FROM Bilhete WHERE idBilhete = ?")) {
            stmt.setInt(1, idBilhete);
            stmt.executeUpdate();
            System.out.println("Bilhete removido.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bilhete> listarB() {
        List<Bilhete> lista = new LinkedList<>();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            // inner_join_para_encontrar_dadossssssssssssssssssssssss
            String sql = "SELECT b.*, p.nome, v.destino, v.preco " +
                    "FROM Bilhete b " +
                    "INNER JOIN Passageiro p ON b.id_passageiro = p.id_passageiro " +
                    "INNER JOIN Viagem v ON b.id_viagem = v.id_viagem";

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Passageiro p = new Passageiro(rs.getInt("id_passageiro"), rs.getString("nome"));
                Viagem v = new Viagem(rs.getInt("id_viagem"), rs.getString("destino"), rs.getDouble("preco"), null);
                Bilhete b = new Bilhete(rs.getInt("idBilhete"), v, p);
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return lista;
    }

    public void atualizarB(int idBilhete, int novoIdViagem, int novoIdPassageiro) {

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();

        String sql = "UPDATE Bilhete SET id_viagem = ?, id_passageiro = ? WHERE idBilhete = ?";

        try (Connection conexao = postgres.getConection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, novoIdViagem);
            stmt.setInt(2, novoIdPassageiro);
            stmt.setInt(3, idBilhete);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Bilhete atualizado com sucesso!");
            } else {
                System.out.println("Bilhete não encontrado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar bilhete: " + e.getMessage());
        }
    }
}
