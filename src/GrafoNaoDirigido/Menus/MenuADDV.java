package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;
import javax.swing.*;
import java.awt.*;

public class MenuADDV extends JFrame {
    private JTextField fixa, caixa;
    private JButton adciona, cancela;

    public MenuADDV(GrafoND grafo){
        setTitle("Adiciona Vertice");
        setSize(300, 100);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        fixa = new JTextField("Vertice");
        fixa.setEditable(false);
        add(fixa);

        caixa = new JTextField(20);
        add(caixa);

        adciona = new JButton("Adicionar");
        adciona.addActionListener(evento -> {
            if (evento.getSource() == adciona) {
                String vertice = caixa.getText();
                grafo.adicionaVertice(vertice);
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
