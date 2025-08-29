package main;

import javax.swing.*;
import dao.LivroDAO;
import model.Livro;
import util.Logger;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastro extends JFrame {
    public TelaCadastro() {
        setTitle("Cadastrar Livro");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2));

        JTextField txtTitulo = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtAno = new JTextField();
        JTextField txtEditora = new JTextField();
        JTextField txtIsbn = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Ano de Publicação:"));
        add(txtAno);
        add(new JLabel("Editora:"));
        add(txtEditora);
        add(new JLabel("ISBN:"));
        add(txtIsbn);
        add(new JLabel(""));
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            if (txtTitulo.getText().isEmpty() || txtAutor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Título e autor são obrigatórios.");
                return;
            }

            try {
                Livro livro = new Livro(
                    txtTitulo.getText(),
                    txtAutor.getText(),
                    Integer.parseInt(txtAno.getText()),
                    txtEditora.getText(),
                    txtIsbn.getText()
                );
                new LivroDAO().cadastrar(livro);
                Logger.registrar("Cadastro de livro: " + livro.getTitulo());
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
