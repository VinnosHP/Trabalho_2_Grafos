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
        //botaoAV.setForeground(new Color(0x1C1C87));
        //botaoAV.setBackground(new Color(0xFFFFFF));
        botaoAV.addActionListener(e -> {
            new MenuADDV(grafo);
        });
        JButton botaoRV = new JButton("Remover Vertice");
        botaoRV.setBounds(75, 100, 300, 50);
        botaoRV.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoRV.setForeground(new Color(0x1C1C87));
        //botaoRV.setBackground(new Color(0xFFFFFF));
        botaoRV.addActionListener(e -> {
            new MenuRemoveV(grafo);
        });
        JButton botaoBL = new JButton("Busca em Largura");
        botaoBL.setBounds(75, 150, 300, 50);
        botaoBL.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoBL.setForeground(new Color(0x1C1C87));
        //botaoBL.setBackground(new Color(0xFFFFFF));

        JButton botaoPRIM = new JButton("Algoritmo de PRIM");
        botaoPRIM.setBounds(75, 200, 300, 50);
        botaoPRIM.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoPRIM.setForeground(new Color(0x1C1C87));
        //botaoPRIM.setBackground(new Color(0xFFFFFF));

        //Lado Direito
        JButton botaoAA = new JButton("Adicionar Aresta");
        botaoAA.setBounds(375, 50, 300, 50);
        botaoAA.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoAA.setForeground(new Color(0x1C1C87));
        //botaoAA.setBackground(new Color(0xFFFFFF));
        botaoAA.addActionListener(e -> {
            new MenuADDA(grafo);
        });
        JButton botaoRA = new JButton("Remover Aresta");
        botaoRA.setBounds(375, 100, 300, 50);
        botaoRA.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoRA.setForeground(new Color(0x1C1C87));
        //botaoRA.setBackground(new Color(0xFFFFFF));
        botaoRA.addActionListener(e -> {
            new MenuRemoveA(grafo);
        });
        JButton botaoBP = new JButton("Busca em Profundidade");
        botaoBP.setBounds(375, 150, 300, 50);
        botaoBP.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoBP.setForeground(new Color(0x1C1C87));
        //botaoBP.setBackground(new Color(0xFFFFFF));

        JButton botaoRoy = new JButton("Algoritmo de Roy");
        botaoRoy.setBounds(375, 200, 300, 50);
        botaoRoy.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoRoy.setForeground(new Color(0x1C1C87));
        //botaoRoy.setBackground(new Color(0xFFFFFF));

        JButton botaoVisualGrafo = new JButton("Ver Grafo");
        botaoVisualGrafo.setBounds(225, 250, 300, 50);
        botaoVisualGrafo.setFont(new Font("Arial", Font.BOLD, 21));
        //botaoVisualGrafo.setForeground(new Color(0x1C1C87));
        //botaoVisualGrafo.setBackground(new Color(0xFFFFFF));
        botaoVisualGrafo.addActionListener(e -> {
            grafo.visualizacao();
        });

        add(botaoAV);add(botaoAA);
        add(botaoRV);add(botaoRA);
        add(botaoBL);add(botaoBP);
        add(botaoPRIM);add(botaoRoy);
        add(botaoVisualGrafo);
    }

    public static void main(String[] args){
        GrafoND grafo = new GrafoND();
        new MenuND(grafo);
    }
}
