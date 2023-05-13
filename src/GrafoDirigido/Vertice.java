package GrafoDirigido;

import java.util.ArrayList;

public class Vertice {
    private String dado;
    private ArrayList<Arco> arcosSaida;
    private ArrayList<Arco> arcosEntrada;

    public Vertice(String dado){
        this.dado = dado;
        this.arcosSaida = new ArrayList<>();
        this.arcosEntrada = new ArrayList<>();
    }

    public String getDado() { return dado; }
    public void setDado(String dado) { this.dado = dado; }
    public void adicionaArcoEntrada(Arco arco){ this.arcosEntrada.add(arco); }
    public void adicionaArcoSaida(Arco arco){ this.arcosSaida.add(arco); }
    public ArrayList<Arco> getArcosSaida() { return arcosSaida; }
    public ArrayList<Arco> getArcosEntrada() { return arcosEntrada; }

    private void removeArcoEntrada(String dado){
        for(int i=0; i<arcosEntrada.size();i++){
            if(arcosEntrada.get(i).getInicio().equals(dado)){
                arcosEntrada.remove(i);
            }
        }
    }

    public void removeArco( String fim){
        for(int i = 0; i<arcosSaida.size(); i++){
            if (arcosSaida.get(i).getFim().equals(fim)){
                removeArcoEntrada(arcosSaida.get(i).getFim());
                arcosSaida.remove(i);
            }
        }
    }

    public void removeTodosArcosSaida(){
        for(int i = 0; i<arcosSaida.size();i++){
            removeArcoEntrada(arcosSaida.get(i).getInicio());
            arcosSaida.remove(i);
        }
    }

    public void removeTodosArcosEntrada(){
        for(int i = 0; i<arcosEntrada.size();i++){
            removeArco(arcosEntrada.get(i).getInicio());
            arcosEntrada.remove(i);
        }
    }
}
