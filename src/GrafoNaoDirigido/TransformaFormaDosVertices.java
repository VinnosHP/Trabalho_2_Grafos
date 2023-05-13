package GrafoNaoDirigido;

import org.apache.commons.collections15.Transformer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TransformaFormaDosVertices implements Transformer<String,Shape> {
    public Shape transform(String vertice){
        return new Ellipse2D.Float(-25,-15,50,30);
    }
}
