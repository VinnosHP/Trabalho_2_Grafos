package GrafoNaoDirigido;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

public class Main extends JFrame{

    /*public Main(GrafoND grafoNO){
        setTitle("Menu");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        //Lado Esquerdo
        JButton botaoAV = new JButton("Adicionar Vertice");
        botaoAV.setBounds(100, 100, 300, 50);
        botaoAV.setFont(new Font("Arial", Font.BOLD, 21));
        botaoAV.setForeground(new Color(0x1C1C87));
        botaoAV.setBackground(new Color(0xFFFFFF));
        botaoAV.addActionListener(e -> { adicionarV(grafoNO); });

        JButton botaoRV = new JButton("Remover Vertice");
        botaoRV.setBounds(100, 150, 300, 50);
        botaoRV.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRV.setForeground(new Color(0x1C1C87));
        botaoRV.setBackground(new Color(0xFFFFFF));
        botaoRV.addActionListener(e -> { removerV(grafoNO); });

        JButton botaoBL = new JButton("Busca em Largura");
        botaoBL.setBounds(100, 200, 300, 50);
        botaoBL.setFont(new Font("Arial", Font.BOLD, 21));
        botaoBL.setForeground(new Color(0x1C1C87));
        botaoBL.setBackground(new Color(0xFFFFFF));
        botaoBL.addActionListener(e -> { buscaL(grafoNO); });

        JButton botaoPRIM = new JButton("Algoritmo de PRIM");
        botaoPRIM.setBounds(100, 250, 300, 50);
        botaoPRIM.setFont(new Font("Arial", Font.BOLD, 21));
        botaoPRIM.setForeground(new Color(0x1C1C87));
        botaoPRIM.setBackground(new Color(0xFFFFFF));
        botaoPRIM.addActionListener(e -> { algoritmoP(grafoNO);});

        //Lado Direito
        JButton botaoAA = new JButton("Adicionar Aresta");
        botaoAA.setBounds(400, 100, 300, 50);
        botaoAA.setFont(new Font("Arial", Font.BOLD, 21));
        botaoAA.setForeground(new Color(0x1C1C87));
        botaoAA.setBackground(new Color(0xFFFFFF));
        botaoAA.addActionListener(e -> { adicionarA(grafoNO); });

        JButton botaoRA = new JButton("Remover Aresta");
        botaoRA.setBounds(400, 150, 300, 50);
        botaoRA.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRA.setForeground(new Color(0x1C1C87));
        botaoRA.setBackground(new Color(0xFFFFFF));
        botaoRA.addActionListener(e -> { removerA(grafoNO); });

        JButton botaoBP = new JButton("Busca em Profundidade");
        botaoBP.setBounds(400, 200, 300, 50);
        botaoBP.setFont(new Font("Arial", Font.BOLD, 21));
        botaoBP.setForeground(new Color(0x1C1C87));
        botaoBP.setBackground(new Color(0xFFFFFF));
        botaoBP.addActionListener(e -> { buscaP(grafoNO); });

        JButton botaoRoy = new JButton("Algoritmo de Roy");
        botaoRoy.setBounds(400, 250, 300, 50);
        botaoRoy.setFont(new Font("Arial", Font.BOLD, 21));
        botaoRoy.setForeground(new Color(0x1C1C87));
        botaoRoy.setBackground(new Color(0xFFFFFF));
        botaoRoy.addActionListener(e -> {
            System.out.println("Nada aqui ainda!");
        });

        //Sair
        JButton sair = new JButton("Sair");
        sair.setBounds(250,300,300,50);
        sair.setFont(new Font("Arial", Font.BOLD, 21));
        sair.setForeground(new Color(0x1C1C87));
        sair.setBackground(new Color(0xFFFFFF));
        sair.addActionListener(e -> { System.exit(0); });

        add(botaoAV);add(botaoAA);
        add(botaoRV);add(botaoRA);
        add(botaoBL);add(botaoBP);
        add(botaoPRIM);add(botaoRoy);
    }*/


    public static void menu(){
        System.out.println("|----------- MENU -----------|");
        System.out.println("|  1 - Adicionar Vertice     |");
        System.out.println("|  2 - Adicionar Aresta      |");
        System.out.println("|  3 - Remover Vertice       |");
        System.out.println("|  4 - Remover Aresta        |");
        System.out.println("|  5 - Busca em Largura      |");
        System.out.println("|  6 - Busca em Profundidade |");
        System.out.println("|  7 - Algoritmo de PRIM     |");
        System.out.println("|  8 - Mostra                |");
        System.out.println("|  9 - Cria Grafo            |");
        System.out.println("| -1 - Sair                  |");
        System.out.println("|----------------------------|");
        System.out.print(" Opção: ");
    }


    public static void adicionarV(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String vertice;
        boolean existe = false;
        do {
            System.out.print("Vertice: ");
            vertice = input.nextLine();
            if (grafoNO.existeVertice(vertice)){
                System.out.println("Vertice já existe!");
                existe = true;
            }
        }while(Objects.equals(vertice, "") && existe);
        grafoNO.adicionaVertice(vertice);
        System.out.print("Vertice Adicionado!");
    }
    public static void adicionarA(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String verticeA, verticeB;
        do {
            System.out.print("Vertice 1: ");
            verticeA = input.nextLine();
            System.out.print("Vertice 2: ");
            verticeB = input.nextLine();
        }while(Objects.equals(verticeA, "") || Objects.equals(verticeB, ""));
        grafoNO.adicionaAresta(verticeA, verticeB);
        System.out.print("Aresta Adicionada!");
    }
    public static void removerV(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice: ");
            vertice = input.nextLine();
        }while(Objects.equals(vertice, ""));
        grafoNO.removeVertice(vertice);
        System.out.println("Vertice Removido!");
    }
    public static void removerA(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String verticeA, verticeB;
        do {
            System.out.print("Vertice A: ");
            verticeA = input.nextLine();
            System.out.print("Vertice B: ");
            verticeB = input.nextLine();
        }while(Objects.equals(verticeA, "") || Objects.equals(verticeB, ""));
        boolean existeA = grafoNO.existeVertice(verticeA);
        boolean existeB = grafoNO.existeVertice(verticeB);
        if (existeA){
            if (existeB){
                Vertice v = grafoNO.buscaVertice(verticeA);
                Vertice v1 = grafoNO.buscaVertice(verticeB);
                for (int i=0; i<v.getArestas().size(); i++){
                    for (int j=0; j<v1.getArestas().size(); j++){
                        if(Objects.equals(v.getArestas().get(i).getId(), v1.getArestas().get(j).getId())){
                            grafoNO.removeArestaG(v.getArestas().get(i).getId());
                        }
                    }
                }
                System.out.println("Aresta Removido!");
            }else System.out.println("Vertice " + verticeB + " não existe!");
        }else System.out.println("Vertice " + verticeA + " não existe!");
    }
    public static void buscaL(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice Inicial: ");
            vertice = input.nextLine();
        }while(Objects.equals(vertice, ""));
        grafoNO.buscaLargura(vertice);
    }
    public static void buscaP(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice Inicial: ");
            vertice = input.nextLine();
        }while(Objects.equals(vertice, ""));
        System.out.print(vertice+"\n");
        grafoNO.buscaProfundidade(vertice);
    }
    public static void algoritmoP(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice Inicial: ");
            vertice = input.nextLine();
        }while(Objects.equals(vertice, ""));
        //grafoNO.AGM(vertice);
    }
    public static void mostra(GrafoND grafoND){
        if (grafoND.existeVerticeG())
            grafoND.mostra();
        else System.out.println("O Grafo não possui vertices!");
    }

    public static void main(String[] args) throws IOException {
        GrafoND grafoNO = new GrafoND();
        int opcao;
        Scanner input = new Scanner(System.in);
        //new Main(grafoNO);
        do{
            menu();
            opcao = input.nextInt();
            switch (opcao) {
                case -1 -> System.out.print("Saindo...");
                case 1 -> adicionarV(grafoNO);
                case 2 -> adicionarA(grafoNO);
                case 3 -> removerV(grafoNO);
                case 4 -> removerA(grafoNO);
                case 5 -> buscaL(grafoNO);          // tem que testar para ver se ta funcionando
                case 6 -> buscaP(grafoNO);          // tem que testar para ver se ta funcionando
                case 7 -> algoritmoP(grafoNO);      // tem que testar para ver se ta funcionando
                case 8 -> mostra(grafoNO);
                case 9 -> grafoNO.visualizacao(); // comenta aqui para não aparecer o grafo
                default -> System.out.println("Opção inválida!");
            }
            System.in.read();
        } while(opcao != -1);
    }
}
