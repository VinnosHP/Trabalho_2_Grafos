package GrafoNaoDirigido;

import org.apache.commons.collections15.Transformer;

import java.awt.*;

public class TransformaLinhasDosVertices implements Transformer<String, Stroke> {
    @Override
    public Stroke transform(String s) {
        return new BasicStroke(3f);
    }
}
