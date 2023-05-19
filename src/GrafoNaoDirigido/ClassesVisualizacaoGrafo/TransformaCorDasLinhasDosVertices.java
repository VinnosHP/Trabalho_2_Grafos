package GrafoNaoDirigido.ClassesVisualizacaoGrafo;

import org.apache.commons.collections15.Transformer;

import java.awt.*;
import java.util.Objects;

public class TransformaCorDasLinhasDosVertices implements Transformer<String, Paint> {
    public Paint transform(String arg0) {
        return Color.BLACK;
    }
    /*private int cor;
    public TransformaCorDasLinhasDosVertices(int cor){
        this.cor = cor;
    }
    public Paint transform(String cor){
        cor = String.valueOf(this.cor);
        if (cor.equals("1")) return Color.RED;
        if (cor.equals("2")) return Color.YELLOW;
        if (cor.equals("3")) return Color.BLUE;
        if (cor.equals("4")) return Color.GREEN;
        return Color.BLACK;
    }*/
}
