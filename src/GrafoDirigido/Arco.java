package GrafoDirigido;

public class Arco {
    private Double peso;
    private String inicio;
    private String fim;

    public Arco(Double peso, String inicio, String fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }
    public String getInicio() { return inicio; }
    public void setInicio(String inicio) { this.inicio = inicio; }
    public String getFim() { return fim; }
    public void setFim(String fim) { this.fim = fim; }
}
