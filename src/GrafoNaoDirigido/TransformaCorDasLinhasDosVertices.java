package GrafoNaoDirigido;

import org.apache.commons.collections15.Transformer;

import java.awt.*;

public class TransformaCorDasLinhasDosVertices implements Transformer<String, Paint> {
    public Paint transform(String arg0) {
        return new Color(0,100,0);
    }
}
