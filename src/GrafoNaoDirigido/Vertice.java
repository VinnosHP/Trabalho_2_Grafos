package GrafoNaoDirigido;

import java.util.ArrayList;
import java.util.Objects;

public class Vertice {
    private String dado;
    private ArrayList<Aresta> arestas;

    public Vertice(String dado){
        this.dado = dado;
        this.arestas = new ArrayList<>();
    }

    public String getDado() { return dado; }
    public void setDado(String dado) { this.dado = dado; }
    public ArrayList<Aresta> getArestas() { return arestas; }
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

        /*for(int i=0; i<arestas.size();i++){
            if((Objects.equals(arestas.get(i).getA(), a) &&
                    Objects.equals(arestas.get(i).getB(), b)) ||
                    (Objects.equals(arestas.get(i).getA(), b) &&
                            Objects.equals(arestas.get(i).getB(), a)) ){
                arestas.remove(i);
                break;
            }
        }*/
    }
    public void mostrarArestas(){
        if (arestas.size() != 0) {
            for (int i = 0; i < arestas.size(); i++) {
                System.out.println(" " + arestas.get(i).getId());
            }
        }else System.out.println("O Vertice " + dado + " não possui arestas!");
    }
}
