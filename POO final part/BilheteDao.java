import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
}
