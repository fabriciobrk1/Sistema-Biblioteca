package main;

import javax.swing.*;
import dao.LivroDAO;
import model.Livro;
import java.awt.*;
import java.util.List;

public class TelaListagem extends JFrame {
    public TelaListagem() {
        setTitle("Listar Livros");
        setSize(600, 400);
        setLayout(new BorderLayout());

        String[] colunas = {"ID", "Título", "Autor", "Ano", "Editora", "ISBN"};
        String[][] dados;

        try {
            List<Livro> livros = new LivroDAO().listar();
            dados = new String[livros.size()][6];
            for (int i = 0; i < livros.size(); i++) {
                Livro l = livros.get(i);
                dados[i][0] = String.valueOf(l.getId());
                dados[i][1] = l.getTitulo();
                dados[i][2] = l.getAutor();
                dados[i][3] = String.valueOf(l.getAnoPublicacao());
                dados[i][4] = l.getEditora();
                dados[i][5] = l.getIsbn();
            }

            JTable tabela = new JTable(dados, colunas);
            add(new JScrollPane(tabela), BorderLayout.CENTER);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }

        setVisible(true);
    }
}
