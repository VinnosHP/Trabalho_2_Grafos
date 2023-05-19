package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;

import javax.swing.*;
import java.awt.*;

public class MenuADDA extends JFrame{
    private JTextField v1,v2,ares,pes,caixa1,caixa2,caixa3,caixa4;
    private JButton adciona, cancela;

    public MenuADDA(GrafoND grafo){
        setTitle("Adiciona Aresta");
        setSize(320, 180);
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

        ares = new JTextField("Aresta");
        ares.setEditable(false);
        add(ares);
        caixa3 = new JTextField(20);
        add(caixa3);

        pes = new JTextField("Peso");
        pes.setEditable(false);
        add(pes);
        caixa4 = new JTextField(20);
        add(caixa4);

        adciona = new JButton("Adicionar");
        adciona.addActionListener(evento -> {
            if (evento.getSource() == adciona) {
                String vertice1 = caixa1.getText();
                String vertice2 = caixa2.getText();
                String aresta = caixa3.getText();
                String pe = caixa4.getText();
                double peso = Double.parseDouble(pe);
                System.out.println("Peso: " + peso);
                grafo.adicionaAresta(vertice1, vertice2, aresta, peso);
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
