package main;

import javax.swing.*;
import java.awt.event.*;

public class Principal extends JFrame {
    public Principal() {
        setTitle("Sistema Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCadastrar = new JButton("Cadastrar Livro");
        btnCadastrar.setBounds(100, 30, 200, 30);
        btnCadastrar.addActionListener(e -> new TelaCadastro());

        JButton btnListar = new JButton("Listar Livros");
        btnListar.setBounds(100, 70, 200, 30);
        btnListar.addActionListener(e -> new TelaListagem());

        JButton btnAtualizar = new JButton("Atualizar Livro");
        btnAtualizar.setBounds(100, 110, 200, 30);
        btnAtualizar.addActionListener(e -> new TelaAtualizacao());

        JButton btnRemover = new JButton("Remover Livro");
        btnRemover.setBounds(100, 150, 200, 30);
        btnRemover.addActionListener(e -> new TelaRemocao());

        

        add(btnCadastrar);
        add(btnListar);
        add(btnRemover);
        add(btnAtualizar);
       
        setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
    }
}
