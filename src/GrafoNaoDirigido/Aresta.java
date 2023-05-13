package GrafoNaoDirigido;

public class Aresta {

    private Double peso;
    private String id;
    private String a; // Aqui ao inves de Fim e Inicio tem Vertice A e Vertice B ja que nao existe direção fixa na aresta.
    private String b;

    public Aresta(String id, Double peso, String a, String b) {
        this.id = id;
        this.peso = peso;
        this.a = a;
        this.b = b;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }
    public String getA() { return a; }
    public void setA(String a) { this.a = a; }
    public String getB() { return b; }
    public void setB(String b) { this.b = b; }
}
