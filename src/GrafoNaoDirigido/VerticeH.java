package GrafoNaoDirigido;

public class VerticeH extends Vertice{
    private double distanciaH;

    public VerticeH(String dado, double distanciaH) {
        super(dado);
        this.distanciaH = distanciaH;
    }

    public double getDistanciaH() {
        return distanciaH;
    }

    public void setDistanciaH(double distanciaH) {
        this.distanciaH = distanciaH;
    }
}
