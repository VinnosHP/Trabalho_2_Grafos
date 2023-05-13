package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;

import javax.swing.*;
import java.awt.*;

public class MenuRemoveV extends JFrame {
    private JTextField fixa, v1;
    private JButton remove, cancela;
    
    public MenuRemoveV(GrafoND grafo){
        setTitle("Remove Vertice");
        setSize(250, 150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        fixa = new JTextField("Vertice");
        fixa.setEditable(false);
        add(fixa);
        v1 = new JTextField(20);
        add(v1);

        remove = new JButton("Remover");
        remove.addActionListener(evento -> {
            if (evento.getSource() == remove) {
                String vertice = v1.getText();
                grafo.removeVertice(vertice);
                JOptionPane.showMessageDialog(null, "Vertice Removido!");
                dispose();
            }
        });
        add(remove);

        cancela = new JButton("Cancelar");
        cancela.addActionListener(evento -> {
            if(evento.getSource() == cancela) {
                dispose();
            }
        });
        add(cancela);
    }
}
