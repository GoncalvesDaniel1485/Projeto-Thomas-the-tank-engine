import java.sql.*;
import java.util.ArrayList;

public class Cadastro {
    // Mantemos as listas para servir como o seu "vetor que se autoincrementa" na
    // memória
    private ArrayList<Motorista> motoristas = new ArrayList<>();
    private ArrayList<Onibus> onibus = new ArrayList<>();
    private ArrayList<Passageiro> passageiros = new ArrayList<>();
    private ArrayList<Viagem> viagens = new ArrayList<>();
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    // --- MÉTODOS DE ADICIONAR (SALVAM NO BANCO E NA LISTA) ---

    public void adicionarMotorista(Motorista m) {
        motoristas.add(m);
        String sql = "INSERT INTO motorista (id_motorista, nome) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, m.getIdMotorista());
            stmt.setString(2, m.getNome());

            stmt.executeUpdate();

            // MENSAGEM DE SUCESSO
            System.out.println("Motorista [" + m.getNome() + "] salvo com sucesso no banco!");

        } catch (SQLException e) {
            // MENSAGEM DE ERRO (Caso o ID já exista ou a tabela não seja encontrada)
            System.err.println("Erro ao salvar motorista: " + e.getMessage());
        }
    }

    public void adicionarOnibus(Onibus o) {
        onibus.add(o);
        String sql = "INSERT INTO onibus (placa_onibus, id_motorista) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, o.getPlacaOnibus());
            stmt.setInt(2, o.getMotorista().getIdMotorista());

            stmt.executeUpdate();

            // MENSAGEM DE SUCESSO
            System.out.println("Ônibus [Placa: " + o.getPlacaOnibus() + "] cadastrado com sucesso no banco!");

        } catch (SQLException e) {
            // MENSAGEM DE ERRO (já existente)
            System.err.println("Erro ao salvar onibus: " + e.getMessage());
        }
    }

    public void adicionarViagem(Viagem v) {
        viagens.add(v); // Adiciona no vetor
        String sql = "INSERT INTO viagem (id_viagem, destino, preco, placa_onibus) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, v.getIdViagem());
            stmt.setString(2, v.getDestino());
            stmt.setDouble(3, v.getPreco());
            stmt.setString(4, v.getOnibus().getPlacaOnibus());

            stmt.executeUpdate();

            // MENSAGEM DE SUCESSO
            System.out.println("Viagem ID " + v.getIdViagem() + " para [" + v.getDestino() + "] salva com sucesso!");

        } catch (SQLException e) {
            // MENSAGEM DE ERRO
            // Se der erro de "coluna não existe", verifique se o nome no banco é
            // placa_onibus
            System.err.println("Erro ao salvar viagem: " + e.getMessage());
        }
    }

    public void adicionarPassageiro(Passageiro p) {
        passageiros.add(p); // Mantém no ArrayList para seus relatórios na memória

        String sql = "INSERT INTO passageiro (id_passageiro, nome) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdPassageiro());
            stmt.setString(2, p.getNome());

            stmt.executeUpdate();
            System.out.println("Passageiro " + p.getNome() + " salvo no banco!");

        } catch (SQLException e) {
            // Se o erro for "chave duplicada", é porque ele já está lá
            System.err.println("Erro ao salvar passageiro: " + e.getMessage());
        }
    }

    public void adicionarBilhete(Bilhete b) {
        bilhetes.add(b);
        String sql = "INSERT INTO bilhete (id_bilhete, valor_pago, id_viagem, id_passageiro) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, b.getIdBilhete());
            stmt.setDouble(2, b.getValorPago());
            stmt.setInt(3, b.getViagem().getIdViagem());
            stmt.setInt(4, b.getPassageiro().getIdPassageiro());

            stmt.executeUpdate();

            // MENSAGEM DE SUCESSO
            System.out.println("Bilhete #" + b.getIdBilhete() + " para o passageiro [" + b.getPassageiro().getNome()
                    + "] salvo com sucesso!");

        } catch (SQLException e) {
            // MENSAGEM DE ERRO
            // Se este erro aparecer, verifique se a Viagem e o Passageiro foram salvos
            // antes!
            System.err.println("Erro ao salvar bilhete: " + e.getMessage());
        }
    }

    // Métodos simples para os outros objetos (opcional salvar no banco também)
    public void adicionarMotorista1(Motorista m) {
        motoristas.add(m);
    }

    public void adicionarOnibus1(Onibus o) {
        onibus.add(o);
    }

    public void adicionarPassageiro1(Passageiro p) {
        passageiros.add(p);
    }

    // --- MÉTODOS DE BUSCA E RELATÓRIO (OS QUE VOCÊ JÁ TINHA) ---

    // Este é o método que você queria: busca pela posição no vetor
    public Viagem consultarPorPosicao(int indice) {
        if (indice >= 0 && indice < viagens.size()) {
            return viagens.get(indice);
        }
        System.out.println("Posição inválida!");
        return null;
    }

    public void exibirRelatorioPassageiros(Viagem v) {
        System.out.println("--- PASSAGEIROS DA VIAGEM: " + v.getDestino() + " ---");
        if (v.getBilhetes().isEmpty()) {
            System.out.println("Nenhum passageiro embarcado.");
        } else {
            for (Bilhete b : v.getBilhetes()) {
                System.out.println("- " + b.getPassageiro().getNome());
            }
        }
    }

    public void exibirDetalhesRota(Viagem v) {
        System.out.println("--- DETALHES DA ROTA ---");
        System.out.println("ID: " + v.getIdViagem() + " | Rota: " + v.getDetalhes());
    }

    public void exibirFinanceiroViagem(Viagem v) {
        double total = 0;
        for (Bilhete b : v.getBilhetes()) {
            total += b.getValorPago();
        }
        System.out.println("--- FINANCEIRO ---");
        System.out.println("Total Arrecadado: R$ " + total);
    }

    public void exibirDetalhesTransporte(Viagem v) {
        Onibus o = v.getOnibus(); // Requer getter em Viagem.java
        Motorista m = o.getMotorista(); // Requer getter em Onibus.java
        System.out.println("--- DETALHES DO TRANSPORTE ---");
        System.out.println("Placa do Ônibus: " + o.getPlacaOnibus());
        System.out.println("Motorista: " + m.getNome());
    }

}