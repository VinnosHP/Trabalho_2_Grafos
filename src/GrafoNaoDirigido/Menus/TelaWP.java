package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;
import GrafoNaoDirigido.Vertice;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaWP extends JFrame {
    private JTextField fixa;
    private JButton sair;
    public TelaWP(GrafoND grafo){
        setTitle("Welsh Powell");
        setSize(350, 150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        ArrayList<Vertice> lista = grafo.WelshPowell();
        for (Vertice vertice : lista) {
            System.out.println("Vertice " + vertice.getDado() + " tem a Cor: " + vertice.getCor());
        }
        /*fixa = new JTextField();
        for (Vertice vertice : lista) {
            JOptionPane.showMessageDialog(null,"Vertice " + vertice.getDado() + " tem a Cor: " + vertice.getCor() + "\n");
            fixa.setText("Vertice " + vertice.getDado() + " tem a Cor: " + vertice.getCor() + "\n");
            fixa.setEditable(false);
            add(fixa);
        }*/

        sair = new JButton("sair");
        sair.addActionListener(evento -> {
            if(evento.getSource() == sair) {
                dispose();
            }
        });
        add(sair);
    }
}

