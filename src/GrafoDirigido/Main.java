package GrafoDirigido;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void menu(){
        System.out.println("|----------- MENU -----------|");
        System.out.println("|  1 - Adicionar Vertice     |");
        System.out.println("|  2 - Adicionar Arco        |");
        System.out.println("|  3 - Remover Vertice       |");
        System.out.println("|  4 - Remover Arco          |");
        System.out.println("|  5 - Busca em Largura      |");
        System.out.println("|  6 - Busca em Profundidade |");
        System.out.println("|  7 - Algoritmo de PRIM     |");
        System.out.println("|  8 - Algoritmo de Roy      |");
        System.out.println("|  9 - Mostrar               |");
        System.out.println("|  -1 - Sair                 |");
        System.out.println("|----------------------------|");
        System.out.print(" Opção: ");
    }
    public static void adicionarV(GrafoD grafo) {
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice: ");
            vertice = input.nextLine();
        }while (Objects.equals(vertice, ""));
        grafo.adicionaVertice(vertice);
        System.out.print("Vertice Adicionado!");
    }
    public static void adicionarA(GrafoD grafo){
        Scanner input = new Scanner(System.in);
        String verticeA, verticeB;
        do {
            System.out.print("Vertice Saida: ");
            verticeA = input.nextLine();
            System.out.print("Vertice Entrada: ");
            verticeB = input.nextLine();
        }while (Objects.equals(verticeA, "") || Objects.equals(verticeB, ""));
        grafo.adicionaArco(verticeA, verticeB);
        System.out.print("Arco Adicionado!");
    }
    public static void removerV(GrafoD grafo){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice: ");
            vertice = input.nextLine();
        }while (Objects.equals(vertice, ""));
        grafo.removeVertice(vertice);
        System.out.print("Vertice Removido!");
    }
    public static void removerA(GrafoD grafo){
        Scanner input = new Scanner(System.in);
        String verticeA, verticeB;
        do {
            System.out.print("Vertice Saida: ");
            verticeA = input.nextLine();
            System.out.print("Vertice Entrada: ");
            verticeB = input.nextLine();
        }while (Objects.equals(verticeA, "") || Objects.equals(verticeB, ""));
        grafo.removeArcoG(verticeA, verticeB);
        System.out.print("Arco Removido!");
    }
    public static void buscaL(GrafoD grafo){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice Inicial: ");
            vertice = input.nextLine();
        }while (Objects.equals(vertice, ""));
        grafo.buscaLargura(vertice);
    }
    public static void buscaP(GrafoD grafo){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice Inicial: ");
            vertice = input.nextLine();
        }while (Objects.equals(vertice, ""));
        System.out.print(vertice);
        grafo.buscaProfundidade(vertice);
    }
    public static void algoritmoP(GrafoD grafo){
        Scanner input = new Scanner(System.in);
        String vertice;
        do {
            System.out.print("Vertice Inicial: ");
            vertice = input.nextLine();
        }while (Objects.equals(vertice, ""));
        grafo.AGM(vertice);
    }
    public static void algoritmoR(){ System.out.print("Nada aqui"); }

    public static void main(String[] args) throws IOException{
        GrafoD grafo = new GrafoD();
        int opcao;
        Scanner input = new Scanner(System.in);
        do{
            menu();
            opcao = input.nextInt();
            switch (opcao) {
                case -1 -> System.out.print("Saindo...");
                case 1 -> adicionarV(grafo);
                case 2 -> adicionarA(grafo);
                case 3 -> removerV(grafo);
                case 4 -> removerA(grafo);
                case 5 -> buscaL(grafo);
                case 6 -> buscaP(grafo);
                case 7 -> algoritmoP(grafo);
                case 8 -> algoritmoR();
                case 9 -> grafo.mostra();
                default -> System.out.print("Opção Inválida!");
            }
            System.in.read();
        } while(opcao != -1);
    }
}
