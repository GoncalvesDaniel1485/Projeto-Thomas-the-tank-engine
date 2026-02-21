import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    public List<Viagem> listarV() {
        List<Viagem> lista = new LinkedList<>();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Viagem");
            rs = stmt.executeQuery();
            while (rs.next()) {
                // Criamos um objeto Onibus "vazio" apenas com a placa para preencher a viagem
                Onibus o = new Onibus(rs.getString("placa_onibus"), null);
                lista.add(new Viagem(rs.getInt("id_viagem"), rs.getString("destino"), rs.getDouble("preco"), o));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return lista;
    }

}