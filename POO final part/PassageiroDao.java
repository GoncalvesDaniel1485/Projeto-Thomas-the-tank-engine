import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Passageiro> listarP() {
        List<Passageiro> lista = new LinkedList<>();
        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conexao = null;
        try {
            conexao = postgres.getConection();
            stmt = conexao.prepareStatement("SELECT * FROM Passageiro ORDER BY id_passageiro");
            rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Passageiro(rs.getInt("id_passageiro"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            postgres.close(rs, stmt, conexao);
        }
        return lista;
    }

    public void atualizarP(int idPassageiro, String novoNome) {

        ConnectionPostgreSQL postgres = new ConnectionPostgreSQL();

        String sql = "UPDATE Passageiro SET nome = ? WHERE id_passageiro = ?";

        try (Connection conexao = postgres.getConection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, idPassageiro);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Passageiro atualizado com sucesso!");
            } else {
                System.out.println("Passageiro não encontrado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar passageiro: " + e.getMessage());
        }
    }
}