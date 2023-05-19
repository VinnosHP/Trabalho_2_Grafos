package GrafoNaoDirigido;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

public class Main extends JFrame{
    public static void menu(){
        System.out.println("|----------- MENU -----------|");
        System.out.println("|  1 - Adicionar Vertice     |");
        System.out.println("|  2 - Adicionar Aresta      |");
        System.out.println("|  3 - Remover Vertice       |");
        System.out.println("|  4 - Remover Aresta        |");
       /* System.out.println("|  5 - Busca em Largura      |");
        System.out.println("|  6 - Busca em Profundidade |");
        System.out.println("|  7 - Algoritmo de PRIM     |");*/
        System.out.println("|  5 - Mostra                |");
        System.out.println("|  6 - Cria Grafo            |");
        System.out.println("|  7 - PLanar                |");
        System.out.println("|  8 - Welsh Powell          |");
        System.out.println("|  9 - A-Star                |");
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
        String verticeA, verticeB, aresta;
        double peso;
        do {
            System.out.print("Vertice 1: ");
            verticeA = input.nextLine();
            System.out.print("Vertice 2: ");
            verticeB = input.nextLine();
            System.out.print("Aresta: ");
            aresta = input.nextLine();
            System.out.print("Peso: ");
            peso = input.nextDouble();
        }while(Objects.equals(verticeA, "") || Objects.equals(verticeB, "")
                || Objects.equals(aresta, "") || peso < 0);
        grafoNO.adicionaAresta(verticeA, verticeB, aresta, peso);
        System.out.print("Aresta Adicionada!");
    }
    public static void removerV(GrafoND grafoNO){
        Scanner input = new Scanner(System.in);
        String vertice;
        boolean existe;
        do {
            System.out.print("Vertice: ");
            vertice = input.nextLine();
            if (!grafoNO.existeVertice(vertice)) {
                System.out.println("Vertice não existe!");
                existe = false;
            }else existe = true;
        }while (Objects.equals(vertice, "") && !existe);
        grafoNO.removeVertice(vertice);
        System.out.println("Vertice removido!");
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
    /*public static void buscaL(GrafoND grafoNO){
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
    }*/
    public static void mostra(GrafoND grafoND){
        if (grafoND.existeVerticeG())
            grafoND.mostra();
        else System.out.println("O Grafo não possui vertices!");
    }
    public static void planar(GrafoND grafoND){
        boolean planar = grafoND.ehPlanar();
        if (planar) System.out.println("Grafo eh planar!");
        else System.out.println("Grafo não eh planar!");
    }
    public static void wp(GrafoND grafoND){
        ArrayList<Vertice> lista = grafoND.WelshPowell();
        System.out.println("wp main");
        grafoND.mostra();
    }

    public static void aEstrela(GrafoND grafo){
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
                System.out.println("cheguei no aEstrela if");
                ArrayList<Vertice> caminho = grafo.aStar(inicio, destino);
                System.out.println("cheguei no for");
                for (Vertice vertice : caminho) {
                    System.out.print(vertice.getDado() + " -> ");
                }
                System.out.print("\n");
            }else System.out.println("Vertice " + inicio + " não existe!");
        }else System.out.println("Vertice " + destino + " não existe!");

    }

    public static void inicializaParana(GrafoND grafo){
        //Adivionando os Vertices
        grafo.adicionaVertice("Curitiba");
        grafo.adicionaVertice("Paranaguá");
        grafo.adicionaVertice("Ponta Grossa");
        grafo.adicionaVertice("Guarapuava");
        grafo.adicionaVertice("Londrina");
        grafo.adicionaVertice("Maringá");
        grafo.adicionaVertice("São Mateus do Sul");
        grafo.adicionaVertice("Umuarama");
        grafo.adicionaVertice("Francisco Beltrão");
        grafo.adicionaVertice("Toledo");
        grafo.adicionaVertice("Cascavel");
        grafo.adicionaVertice("Foz do Iguaçu");
        //Adicionando as arestas
        grafo.adicionaAresta("Paranaguá",         "Curitiba",         "PC",90);
        grafo.adicionaAresta("Curitiba",          "Ponta Grossa",     "CP",114);
        grafo.adicionaAresta("Curitiba",          "São Mateus do Sul","CS",157);
        grafo.adicionaAresta("Ponta Grossa",      "Londrina",         "PL",273);
        grafo.adicionaAresta("Ponta Grossa",      "Maringá",          "PM",314);
        grafo.adicionaAresta("Ponta Grossa",      "Guarapuava",       "PG",165);
        grafo.adicionaAresta("São Mateus do Sul", "Francisco Beltrão","SF",354);
        grafo.adicionaAresta("Londrina",          "Maringá",          "LM",114);
        grafo.adicionaAresta("Maringá",           "Umuarama",         "MU",190);
        grafo.adicionaAresta("Umuarama",          "Toledo",           "UT",126);
        grafo.adicionaAresta("Guarapuava",        "Cascavel",         "GC",250);
        grafo.adicionaAresta("Francisco Beltrão", "Cascavel",         "FC",186);
        grafo.adicionaAresta("Toledo",            "Cascavel",         "TC",50);
        grafo.adicionaAresta("Cascavel",          "Foz do Iguaçu",    "CF",143);
    }

    public static void main(String[] args) throws IOException {
        GrafoND grafoNO = new GrafoND();
        GrafoND grafoP = new GrafoND();
        int opcao;
        Scanner input = new Scanner(System.in);
        inicializaParana(grafoP);
        do{
            menu();
            opcao = input.nextInt();
            switch (opcao) {
                case -1 -> System.out.print("Saindo...");
                case 1 -> adicionarV(grafoNO);
                case 2 -> adicionarA(grafoNO);
                case 3 -> removerV(grafoNO);
                case 4 -> removerA(grafoNO);
                /*case 5 -> buscaL(grafoNO);          // tem que testar para ver se ta funcionando
                case 6 -> buscaP(grafoNO);          // tem que testar para ver se ta funcionando
                case 7 -> algoritmoP(grafoNO);      // tem que testar para ver se ta funcionando*/
                case 5 -> mostra(grafoNO);
                case 6 -> grafoNO.visualizacao();   // comenta aqui para não aparecer o grafo
                case 7 -> planar(grafoNO);
                case 8 -> wp(grafoNO);
                case 9 -> aEstrela(grafoP);
                default -> System.out.println("Opção inválida!");
            }
            System.in.read();
        } while(opcao != -1);
    }
}
