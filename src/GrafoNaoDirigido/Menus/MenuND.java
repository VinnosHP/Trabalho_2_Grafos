package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;

import javax.swing.*;
import java.awt.*;

public class MenuND extends JFrame {
    public MenuND(GrafoND grafo){
        setTitle("Menu Não Dirigido");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Lado Esquerdo
        JButton botaoAV = new JButton("Adicionar Vertice");
        botaoAV.setBounds(75, 50, 300, 50);
        botaoAV.setFont(new Font("Arial", Font.BOLD, 21));
        botaoAV.addActionListener(e -> {
            new MenuADDV(grafo);
        });
        JButton botaoRV = new JButton("Remover Vertice");
        botaoRV.setBounds(75, 100, 300, 50);
        botaoRV.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRV.addActionListener(e -> {
            new MenuRemoveV(grafo);
        });

        //Lado Direito
        JButton botaoAA = new JButton("Adicionar Aresta");
        botaoAA.setBounds(375, 50, 300, 50);
        botaoAA.setFont(new Font("Arial", Font.BOLD, 21));
        botaoAA.addActionListener(e -> {
            new MenuADDA(grafo);
        });
        JButton botaoRA = new JButton("Remover Aresta");
        botaoRA.setBounds(375, 100, 300, 50);
        botaoRA.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRA.addActionListener(e -> {
            new MenuRemoveA(grafo);
        });

        JButton botaoVisualGrafo = new JButton("Ver Grafo");
        botaoVisualGrafo.setBounds(225, 250, 300, 50);
        botaoVisualGrafo.setFont(new Font("Arial", Font.BOLD, 21));
        botaoVisualGrafo.addActionListener(e -> {
            grafo.mostra();
            grafo.visualizacao();
        });

        add(botaoAV);add(botaoAA);
        add(botaoRV);add(botaoRA);
        add(botaoVisualGrafo);
    }

    public static void main(String[] args){
        GrafoND grafo = new GrafoND();
        new MenuND(grafo);
    }
}
