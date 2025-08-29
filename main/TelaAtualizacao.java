package main;

import javax.swing.*;
import dao.LivroDAO;
import model.Livro;
import util.Logger;
import java.awt.*;
import java.awt.event.*;

public class TelaAtualizacao extends JFrame {
    public TelaAtualizacao() {
        setTitle("Atualizar Livro");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2));

        JTextField txtId = new JTextField();
        JTextField txtTitulo = new JTextField();
        JTextField txtAutor = new JTextField();
        JTextField txtAno = new JTextField();
        JTextField txtEditora = new JTextField();
        JTextField txtIsbn = new JTextField();

        JButton btnAtualizar = new JButton("Atualizar");

        add(new JLabel("ID do Livro:"));
        add(txtId);
        add(new JLabel("Novo Título:"));
        add(txtTitulo);
        add(new JLabel("Novo Autor:"));
        add(txtAutor);
        add(new JLabel("Novo Ano:"));
        add(txtAno);
        add(new JLabel("Nova Editora:"));
        add(txtEditora);
        add(new JLabel("Novo ISBN:"));
        add(txtIsbn);
        add(new JLabel(""));
        add(btnAtualizar);

        btnAtualizar.addActionListener(e -> {
            try {
                Livro livro = new Livro(
                    txtTitulo.getText(),
                    txtAutor.getText(),
                    Integer.parseInt(txtAno.getText()),
                    txtEditora.getText(),
                    txtIsbn.getText()
                );
                livro.setId(Integer.parseInt(txtId.getText()));
                new LivroDAO().atualizar(livro);
                Logger.registrar("Atualização de livro ID: " + livro.getId());
                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
