package GrafoNaoDirigido;

import org.apache.commons.collections15.Transformer;

import java.awt.*;

public class TransformaCorDasLinhasDasArestas implements Transformer<String, Paint> {
    public Paint transform(String aresta) {
        return Color.BLUE;
    }
}
