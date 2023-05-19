package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;
import javax.swing.*;
import java.awt.*;

public class MenuADDV extends JFrame {
    private JTextField fixaV,fixaX,fixaY,caixaV,caixaX,caixaY;
    private JButton adciona, cancela;

    public MenuADDV(GrafoND grafo){
        setTitle("Adiciona Vertice");
        setSize(350, 150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        fixaV = new JTextField("Vertice");
        fixaV.setEditable(false);
        add(fixaV);
        caixaV = new JTextField(20);
        add(caixaV);

        fixaX = new JTextField("Coordenada X");
        fixaX.setEditable(false);
        add(fixaX);
        caixaX = new JTextField(20);
        add(caixaX);

        fixaY = new JTextField("Coordenada Y");
        fixaY.setEditable(false);
        add(fixaY);
        caixaY = new JTextField(20);
        add(caixaY);

        adciona = new JButton("Adicionar");
        adciona.addActionListener(evento -> {
            if (evento.getSource() == adciona) {
                String vertice = caixaV.getText();
                String x = caixaX.getText();
                String y = caixaY.getText();
                double xs = Double.parseDouble(x);
                double ys = Double.parseDouble(y);
                System.out.println("X: " + xs);
                System.out.println("Y: " + ys);
                grafo.adicionaVertice(vertice, xs, ys);
                JOptionPane.showMessageDialog(null, "Vertice Adcionado!");
                dispose();
            }
        });
        add(adciona);

        cancela = new JButton("Cancelar");
        cancela.addActionListener(evento -> {
            if(evento.getSource() == cancela) {
                dispose();
            }
        });
        add(cancela);
    }
}
