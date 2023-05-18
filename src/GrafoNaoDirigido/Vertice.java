package GrafoNaoDirigido;

import java.util.ArrayList;
import java.util.Objects;

public class Vertice {
    //Atributos
    private String dado;
    private double x;
    private double y;
    private int cor;
    private final ArrayList<Aresta> arestas;

    //Construtores
    public Vertice(String dado){
        this.dado = dado;
        x = 0;
        y = 0;
        cor = -1;
        arestas = new ArrayList<>();
    }
    public Vertice(String dado, double x, double y){
        this.dado = dado;
        this.x = x;
        this.y = y;
        cor = -1;
        arestas = new ArrayList<>();
    }
    public Vertice(String dado, int cor) {
        this.dado = dado;
        this.cor = cor;
        x = 0;
        y = 0;
        arestas = new ArrayList<>();
    }

    //GETs
    public String getDado() { return dado; }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getCor() {
        return cor;
    }
    public ArrayList<Aresta> getArestas() { return arestas; }

    //SETs
    public void setDado(String dado) { this.dado = dado; }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setCor(int cor) {
        this.cor = cor;
    }

    //Outros metodos
    public void adicionaAresta(Aresta aresta){
        boolean igual = false;
        for (Aresta value : arestas) {
            if (Objects.equals(value.getId(), aresta.getId())) {
                igual = true;
                break;
            }
        }
        if (!igual)
            arestas.add(aresta);
        else System.out.println("Aresta ja existe!");
    }
    public void removeAresta(String id){
        for (int i=0; i<arestas.size(); i++){
            if (Objects.equals(arestas.get(i).getId(), id)) {
                arestas.remove(i);
                break;
            }
        }
    }
    public void mostrarArestas(){
        if (arestas.size() != 0) {
            for (Aresta aresta : arestas) {
                System.out.println(" " + aresta.getId());
            }
        }else System.out.println("O Vertice " + dado + " não possui arestas!");
    }
}
