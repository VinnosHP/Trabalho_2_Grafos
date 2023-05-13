package GrafoNaoDirigido;

import org.apache.commons.collections15.Transformer;

import java.awt.*;

public class TransformaPreenchimentoDosVertices implements Transformer<String, Paint> {
    public Paint transform(String vertice){
        return new Color(255,255,240);
    }
}
