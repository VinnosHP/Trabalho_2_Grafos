package GrafoNaoDirigido;

import org.apache.commons.collections15.Transformer;

import java.awt.*;

public class TransformaFontesDosVertices implements Transformer<String,Font> {
    public Font transform(String vertice){
        return new Font("Serif",Font.PLAIN,18);
    }
}
