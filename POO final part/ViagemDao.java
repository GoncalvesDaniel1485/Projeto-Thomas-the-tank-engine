import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ViagemDao {

    public void adicionarV(Viagem viagem) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = postgres.getConection();
            
            // O SQL deve refletir as colunas da tabela Viagem
            // id_viagem (PK), origem, destino, preco, placa_onibus (FK)
            String sql = "INSERT INTO Viagem (id_viagem, origem, destino, preco, placa_onibus) VALUES (?, ?, ?, ?, ?)";
            
            stmt = conexao.prepareStatement(sql);
            
            // 1. Atributos diretos da classe Viagem
            stmt.setInt(1, viagem.getIdViagem());
            stmt.setString(2, "Rodoviária RT"); // Valor padrão definido na sua classe
            stmt.setString(3, viagem.getDestino());
            stmt.setDouble(4, viagem.getPreco());

            // 2. A CHAVE ESTRANGEIRA:
            // Pegamos a placa de dentro do objeto Onibus que está associado à Viagem
            if (viagem.getOnibus() != null) {
                stmt.setString(5, viagem.getOnibus().getPlacaOnibus());
            } else {
                // Caso a viagem seja criada sem um ônibus definido (opcional, dependendo da sua regra)
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }

            stmt.executeUpdate();
            System.out.println("Viagem para " + viagem.getDestino() + " registrada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir viagem: " + e.getMessage());
        } finally {
            postgres.close(stmt, conexao);
        }
    }

    public void removerV(int idViagem) {
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        try (Connection conexao = postgres.getConection();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM Viagem WHERE id_viagem = ?")) {
            stmt.setInt(1, idViagem);
            stmt.executeUpdate();
            System.out.println("Viagem removida.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
}