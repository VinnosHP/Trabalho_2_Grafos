package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;
import GrafoNaoDirigido.Vertice;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class TelaAE extends JFrame {
    private JTextField fixaI, fixaD, caixaI, caixaD, fixa;
    private JButton sair, estrela;
    public TelaAE(GrafoND grafo){
        setTitle("A-Estrela");
        setSize(350, 150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        fixaI = new JTextField("Vertice inicial");
        fixaI.setEditable(false);
        add(fixaI);
        caixaI = new JTextField(20);
        add(caixaI);

        fixaD = new JTextField("Vertice destino");
        fixaD.setEditable(false);
        add(fixaD);
        caixaD = new JTextField(20);
        add(caixaD);

        fixa = new JTextField();

        estrela = new JButton("Adicionar");
        estrela.addActionListener(evento -> {
            if (evento.getSource() == estrela) {
                String inicio = caixaI.getText();
                String destino = caixaD.getText();
                boolean existeI = grafo.existeVertice(inicio);
                boolean existeD = grafo.existeVertice(destino);
                if (existeD){
                    if (existeI){
                        ArrayList<Vertice> caminho = grafo.aStar(inicio, destino);
                        for (Vertice vertice : caminho) {
                            fixa.setText(vertice.getDado() + " -> ");
                            fixa.setEditable(false);
                            add(fixa);
                        }
                        JOptionPane.showMessageDialog(null,
                                "\n Custo: " + grafo.precoAteAqui(caminho) + "\n");
                    }else JOptionPane.showMessageDialog(null,"Vertice " + inicio + " não existe!");
                }else JOptionPane.showMessageDialog(null,"Vertice " + destino + " não existe!");

                dispose();
            }
        });
        add(estrela);

        sair = new JButton("sair");
        sair.addActionListener(evento -> {
            if(evento.getSource() == sair) {
                dispose();
            }
        });
        add(sair);
    }
}
