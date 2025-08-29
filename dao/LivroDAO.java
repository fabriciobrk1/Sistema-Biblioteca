package dao;

import model.Livro;
import util.ConexaoMySQL;
import java.sql.*;
import java.util.*;

public class LivroDAO {
    public void cadastrar(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros (titulo, autor, anoPublicacao, editora, isbn) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setString(4, livro.getEditora());
            stmt.setString(5, livro.getIsbn());
            stmt.executeUpdate();
        }
    }

    public List<Livro> listar() throws SQLException {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
                livro.setEditora(rs.getString("editora"));
                livro.setIsbn(rs.getString("isbn"));
                lista.add(livro);
            }
        }
        return lista;
    }

    public void atualizar(Livro livro) throws SQLException {
    String sql = "UPDATE livros SET titulo = ?, autor = ?, anoPublicacao = ?, editora = ?, isbn = ? WHERE id = ?";
    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setInt(3, livro.getAnoPublicacao());
        stmt.setString(4, livro.getEditora());
        stmt.setString(5, livro.getIsbn());
        stmt.setInt(6, livro.getId());
        stmt.executeUpdate();
    }
}

public void remover(int id) throws SQLException {
    String sql = "DELETE FROM livros WHERE id = ?";
    try (Connection conn = ConexaoMySQL.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}

    
}
