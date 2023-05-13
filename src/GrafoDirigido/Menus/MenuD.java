package GrafoDirigido.Menus;

import GrafoDirigido.GrafoD;

import javax.swing.*;
import java.awt.*;

public class MenuD extends JFrame {
    public MenuD(GrafoD grafo){
        setTitle("Menu Dirigido");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton botaoAV = new JButton("Adicionar Vertice");
        botaoAV.setBounds(100, 100, 300, 50);
        botaoAV.setFont(new Font("Arial", Font.BOLD, 21));
        botaoAV.setForeground(new Color(0x1C1C87));
        botaoAV.setBackground(new Color(0xFFFFFF));
        botaoAV.addActionListener(e -> {

        });
        JButton botaoRV = new JButton("Remover Vertice");
        botaoRV.setBounds(100, 150, 300, 50);
        botaoRV.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRV.setForeground(new Color(0x1C1C87));
        botaoRV.setBackground(new Color(0xFFFFFF));
        botaoRV.addActionListener(e -> {

        });
        JButton botaoBL = new JButton("Busca em Largura");
        botaoBL.setBounds(100, 200, 300, 50);
        botaoBL.setFont(new Font("Arial", Font.BOLD, 21));
        botaoBL.setForeground(new Color(0x1C1C87));
        botaoBL.setBackground(new Color(0xFFFFFF));

        JButton botaoPRIM = new JButton("Algoritmo de PRIM");
        botaoPRIM.setBounds(100, 250, 300, 50);
        botaoPRIM.setFont(new Font("Arial", Font.BOLD, 21));
        botaoPRIM.setForeground(new Color(0x1C1C87));
        botaoPRIM.setBackground(new Color(0xFFFFFF));

        //Lado Direito
        JButton botaoAA = new JButton("Adicionar Aresta");
        botaoAA.setBounds(400, 100, 300, 50);
        botaoAA.setFont(new Font("Arial", Font.BOLD, 21));
        botaoAA.setForeground(new Color(0x1C1C87));
        botaoAA.setBackground(new Color(0xFFFFFF));
        botaoAA.addActionListener(e -> {

        });
        JButton botaoRA = new JButton("Remover Aresta");
        botaoRA.setBounds(400, 150, 300, 50);
        botaoRA.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRA.setForeground(new Color(0x1C1C87));
        botaoRA.setBackground(new Color(0xFFFFFF));
        botaoRA.addActionListener(e -> {

        });
        JButton botaoBP = new JButton("Busca em Profundidade");
        botaoBP.setBounds(400, 200, 300, 50);
        botaoBP.setFont(new Font("Arial", Font.BOLD, 21));
        botaoBP.setForeground(new Color(0x1C1C87));
        botaoBP.setBackground(new Color(0xFFFFFF));

        JButton botaoRoy = new JButton("Algoritmo de Roy");
        botaoRoy.setBounds(400, 250, 300, 50);
        botaoRoy.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRoy.setForeground(new Color(0x1C1C87));
        botaoRoy.setBackground(new Color(0xFFFFFF));

        JButton botaoVisualGrafo = new JButton("Ver Grafo");
        botaoVisualGrafo.setBounds(250, 300, 300, 50);
        botaoVisualGrafo.setFont(new Font("Arial", Font.BOLD, 21));
        botaoVisualGrafo.setForeground(new Color(0x1C1C87));
        botaoVisualGrafo.setBackground(new Color(0xFFFFFF));
        botaoVisualGrafo.addActionListener(e -> {

        });

        add(botaoAV);add(botaoAA);
        add(botaoRV);add(botaoRA);
        add(botaoBL);add(botaoBP);
        add(botaoPRIM);add(botaoRoy);
        add(botaoVisualGrafo);
    }
    public static void main(String[] args){
        GrafoD grafo = new GrafoD();
        new MenuD(grafo);
    }
}
