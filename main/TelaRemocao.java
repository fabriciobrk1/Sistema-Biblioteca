package main;

import javax.swing.*;
import dao.LivroDAO;
import util.Logger;
import java.awt.*;

public class TelaRemocao extends JFrame {
    public TelaRemocao() {
        setTitle("Remover Livro");
        setSize(300, 150);
        setLayout(new GridLayout(3, 1));

        JTextField txtId = new JTextField();
        JButton btnRemover = new JButton("Remover");

        add(new JLabel("ID do Livro a remover:"));
        add(txtId);
        add(btnRemover);

        btnRemover.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                new LivroDAO().remover(id);
                Logger.registrar("Remoção de livro ID: " + id);
                JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
