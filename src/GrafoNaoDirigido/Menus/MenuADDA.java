package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;

import javax.swing.*;
import java.awt.*;

public class MenuADDA extends JFrame{
    private JTextField v1, v2, caixa1, caixa2;
    private JButton adciona, cancela;

    public MenuADDA(GrafoND grafo){
        setTitle("Adiciona Aresta");
        setSize(350, 150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        v1 = new JTextField("Vertice 1");
        v1.setEditable(false);
        add(v1);
        caixa1 = new JTextField(20);
        add(caixa1);

        v2 = new JTextField("Vertice 2");
        v2.setEditable(false);
        add(v2);
        caixa2 = new JTextField(20);
        add(caixa2);

        adciona = new JButton("Adicionar");
        adciona.addActionListener(evento -> {
            if (evento.getSource() == adciona) {
                String vertice1 = caixa1.getText();
                String vertice2 = caixa2.getText();
                grafo.adicionaAresta(vertice1, vertice2);
                JOptionPane.showMessageDialog(null, "Aresta Adcionada!");
                grafo.mostra();
                dispose();
            }
        });
        add(adciona);

        cancela = new JButton("Cancelar");
        cancela.addActionListener(evento -> {
            if(evento.getSource() == cancela) {
                dispose();
            }
        });
        add(cancela);
    }
}
