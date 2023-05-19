package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;
import GrafoNaoDirigido.Vertice;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MenuND extends JFrame {
    public MenuND(GrafoND grafo){
        setTitle("Menu Não Dirigido");
        setSize(750, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Lado Esquerdo Tela
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
        JButton botaoPlanar = new JButton("Planar");
        botaoPlanar.setBounds(75,150,300,50);
        botaoPlanar.setFont(new Font("Arial", Font.BOLD, 21));
        botaoPlanar.addActionListener(e -> {
            if (e.getSource() == botaoPlanar){
                boolean planar = grafo.ehPlanar();
                if (planar) JOptionPane.showMessageDialog(null, "Grafo eh Planar!");
                else JOptionPane.showMessageDialog(null, "Grafo não eh planar!");
            }
        });
        JButton botaoAE = new JButton("A-Estrela");
        botaoAE.setBounds(75,200,300,50);
        botaoAE.setFont(new Font("Arial", Font.BOLD, 21));
        botaoAE.addActionListener(e -> {
            if (e.getSource() == botaoAE) {
                JOptionPane.showMessageDialog(null, "Olhar no console!");
                Scanner input = new Scanner(System.in);
                String inicio, destino;
                do {
                    System.out.print("Vertice destino: ");
                    destino = input.nextLine();
                    System.out.print("Vertice inicio: ");
                    inicio = input.nextLine();
                }while(Objects.equals(destino, "") || Objects.equals(inicio, ""));
                boolean existeD = grafo.existeVertice(destino);
                boolean existeI = grafo.existeVertice(inicio);
                if (existeD){
                    if (existeI){
                        ArrayList<Vertice> caminho = grafo.aStar(inicio, destino);
                        for (int i = 0; i < caminho.size(); i++) {
                            if (i+1 < caminho.size()) System.out.print(caminho.get(i).getDado() + " -> ");
                            else System.out.print(caminho.get(i).getDado());
                        }
                        //System.out.print("\n Custo: " + grafo.precoAteAqui(caminho) + "\n");
                    }else System.out.println("Vertice " + inicio + " não existe!");
                }else System.out.println("Vertice " + destino + " não existe!");
            }
        });

        //Lado Direito Tela
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
        JButton botaoWP = new JButton("Welsh Powell");
        botaoWP.setBounds(375,150,300,50);
        botaoWP.setFont(new Font("Arial", Font.BOLD, 21));
        botaoWP.addActionListener(e -> {
            if (e.getSource() == botaoWP) {
                ArrayList<Vertice> lista = grafo.WelshPowell();
                for (Vertice vertice : lista) {
                    System.out.println("Vertice " + vertice.getDado() + " tem a Cor: " + vertice.getCor());
                }
                JOptionPane.showMessageDialog(null, "Olhar no console!");
            }
        });
        JButton botaoVisualGrafo = new JButton("Ver Grafo");
        botaoVisualGrafo.setBounds(375, 200, 300, 50);
        botaoVisualGrafo.setFont(new Font("Arial", Font.BOLD, 21));
        botaoVisualGrafo.addActionListener(e -> {
            if (e.getSource() == botaoVisualGrafo) {
                System.out.println("\n");
                grafo.mostra();
                grafo.visualizacao();
            }
        });

        JButton botaoIG = new JButton("Inicializa Grafo");
        botaoIG.setBounds(225, 250, 300, 50);
        botaoIG.setFont(new Font("Arial", Font.BOLD, 21));
        botaoIG.addActionListener(e -> {
            new InicializaGrafo(grafo);
        });

        //ADDs dos botoes ao Menu principal
        add(botaoAV);add(botaoAA);
        add(botaoRV);add(botaoRA);
        add(botaoPlanar);add(botaoWP);
        add(botaoAE);add(botaoVisualGrafo);
        add(botaoIG);
    }

    public static void inicializaParana(GrafoND grafoP){
        //Adivionando os Vertices
        grafoP.adicionaVertice("Curitiba",-25.4284,-49.2733);
        grafoP.adicionaVertice("Paranaguá",-25.5205,-48.5095);
        grafoP.adicionaVertice("Ponta Grossa",-25.0945,-50.1633);
        grafoP.adicionaVertice("Guarapuava",-25.3935,-51.4562);
        grafoP.adicionaVertice("Londrina",-23.2927,-51.1732);
        grafoP.adicionaVertice("Maringá",-23.4273,-51.9375);
        grafoP.adicionaVertice("São Mateus do Sul",-25.8767,-50.3842);
        grafoP.adicionaVertice("Umuarama",-23.7641,-53.3184);
        grafoP.adicionaVertice("Francisco Beltrão",-26.0783,-53.0531);
        grafoP.adicionaVertice("Toledo",-24.7199,-53.7433);
        grafoP.adicionaVertice("Cascavel",-24.9555,-53.4552);
        grafoP.adicionaVertice("Foz do Iguaçu",-25.54698,-54.5882);
        //Adicionando as arestas
        grafoP.adicionaAresta("Paranaguá",         "Curitiba",         "PC",90);
        grafoP.adicionaAresta("Curitiba",          "Ponta Grossa",     "CP",114);
        grafoP.adicionaAresta("Curitiba",          "São Mateus do Sul","CS",157);
        grafoP.adicionaAresta("Ponta Grossa",      "Londrina",         "PL",273);
        grafoP.adicionaAresta("Ponta Grossa",      "Maringá",          "PM",314);
        grafoP.adicionaAresta("Ponta Grossa",      "Guarapuava",       "PG",165);
        grafoP.adicionaAresta("São Mateus do Sul", "Francisco Beltrão","SF",354);
        grafoP.adicionaAresta("Londrina",          "Maringá",          "LM",114);
        grafoP.adicionaAresta("Maringá",           "Umuarama",         "MU",190);
        grafoP.adicionaAresta("Umuarama",          "Toledo",           "UT",126);
        grafoP.adicionaAresta("Guarapuava",        "Cascavel",         "GC",250);
        grafoP.adicionaAresta("Francisco Beltrão", "Cascavel",         "FC",186);
        grafoP.adicionaAresta("Toledo",            "Cascavel",         "TC",50);
        grafoP.adicionaAresta("Cascavel",          "Foz do Iguaçu",    "CF",143);
    }
    public static void main(String[] args){
        GrafoND grafo = new GrafoND();
        /*GrafoND grafoP = new GrafoND();
        inicializaParana(grafoP);
        new MenuND(grafoP);*/
        new MenuND(grafo);
    }
}
