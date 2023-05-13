package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;
import GrafoNaoDirigido.Vertice;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MenuRemoveA extends JFrame{
    private JTextField fixa, v1, v2;
    private JButton remove, cancela;
    
    public MenuRemoveA(GrafoND grafo){
        setTitle("Remove Aresta");
        setSize(350, 150);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        fixa = new JTextField("Vertice 1");
        fixa.setEditable(false);
        add(fixa);
        v1 = new JTextField(20);
        add(v1);

        fixa = new JTextField("Vertice 2");
        fixa.setEditable(false);
        add(fixa);
        v2 = new JTextField(20);
        add(v2);

        remove = new JButton("Remover");
        remove.addActionListener(evento -> {
            if (evento.getSource() == remove) {
                String vertice1 = v1.getText();
                String vertice2 = v2.getText();
                boolean existeA = grafo.existeVertice(vertice1);
                boolean existeB = grafo.existeVertice(vertice2);
                if (existeA){
                    if (existeB){
                        Vertice v = grafo.buscaVertice(vertice1);
                        Vertice v1 = grafo.buscaVertice(vertice2);
                        for (int i=0; i<v.getArestas().size(); i++){
                            for (int j=0; j<v1.getArestas().size(); j++){
                                if(Objects.equals(v.getArestas().get(i).getId(), v1.getArestas().get(j).getId())){
                                    grafo.removeArestaG(v.getArestas().get(i).getId());
                                }
                            }
                        }
                        System.out.println("Aresta Removido!");
                    }else System.out.println("Vertice " + vertice2 + " não existe!");
                }else System.out.println("Vertice " + vertice1 + " não existe!");
                JOptionPane.showMessageDialog(null, "Aresta Removida!");
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
