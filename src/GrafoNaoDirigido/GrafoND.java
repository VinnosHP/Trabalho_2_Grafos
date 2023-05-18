package GrafoNaoDirigido;

import GrafoNaoDirigido.ClassesVisualizacaoGrafo.*;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class GrafoND{

    private final ArrayList<Vertice> vertices;
    private final ArrayList<Aresta> arestas;
    private final ArrayList<String> marcados;
    private final ArrayList<VerticeH> h;

    public GrafoND(){
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.marcados = new ArrayList<>();
        this.h = new ArrayList<>();
    }

    public void adicionaVertice(String dado){
        Vertice novoV = new Vertice(dado);
        vertices.add(novoV);
    }

    public void removeVertice(String dado){
        for(int i=0; i < vertices.size(); i++){
            if(Objects.equals(vertices.get(i).getDado(), dado)){ // Procura o vertice no array
                for (int j=0; j < vertices.get(i).getArestas().size(); j++){
                    vertices.get(i).removeAresta(vertices.get(i).getArestas().get(0).getId());
                }
                vertices.remove(i);
                break;
            }
        }
    }

    public void adicionaAresta(String dadoA, String dadoB){
        boolean existeA = existeVertice(dadoA);
        boolean existeB = existeVertice(dadoB);
        if (existeA){
            if (existeB){
                String c = dadoA.concat(dadoB);
                Aresta a = new Aresta(c, 1.0, dadoA, dadoB);
                Vertice v = buscaVertice(dadoA);
                Vertice v1 = buscaVertice(dadoB);
                v.adicionaAresta(a);
                v1.adicionaAresta(a);
                arestas.add(a);
            }else System.out.println("Vertice " + dadoB + " não existe!");
        }else System.out.println("Vertice " + dadoA + " não existe!");
    }

    public void removeArestaG(String id) {
        for (Vertice value : vertices) {
            for (int j = 0; j < value.getArestas().size(); j++) {
                if (Objects.equals(value.getArestas().get(j).getId(), id)) {
                    for (Aresta arest : arestas) {
                        if (Objects.equals(arest.getId(), value.getArestas().get(j).getId())) {
                            arestas.remove(j);
                            break;
                        }
                    }
                    value.removeAresta(value.getArestas().get(j).getId());
                    break;
                }
            }
        }
        /*
        for(int i=0; i < arestas.size(); i++){
            if(Objects.equals(arestas.get(i).getA(), dadoA) && Objects.equals(arestas.get(i).getB(), dadoB)){ // Procura no array a aresta
                for (Vertice vertex : vertices) {
                    if (Objects.equals(vertex.getDado(), dadoA) || Objects.equals(vertex.getDado(), dadoB)) { // Procura os vertices que tao ligados pela aresta
                        vertex.removeAresta(vertex.getArestas().get()); // Remove essa aresta em cada um dos vertices
                    }
                }
                arestas.remove(i); // Remove a aresta do array
                break;
            }
        }
        */
    }

    public boolean existeVertice(String dado){
        for (Vertice vertex : vertices) {
            if (Objects.equals(vertex.getDado(), dado)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeVerticeG(){
        return vertices.size() != 0;
    }

    public boolean existeAresta(String dado){
        for (Aresta vertex : arestas) {
            if (Objects.equals(vertex.getId(), dado)) {
                return true;
            }
        }
        return false;
    }

    public Vertice buscaVertice(String dado){
        Vertice vertice = null;
        for (Vertice vertex : vertices) {
            if (Objects.equals(vertex.getDado(), dado)) {
                vertice = vertex;
                break;
            }
        }
        return vertice;
    }

    public Aresta buscaAresta(String dado){
        Aresta aresta = null;
        for (Aresta stringAresta : arestas) {
            if (stringAresta.getId().equals(dado)) {
                aresta = stringAresta;
                break;
            }
        }
        return aresta;
    }

    public int getVerticePosition(String dado){ // A partir do dado do vertice busca qual indice ele ta na lista
        for(int i=0; i < this.vertices.size(); i++){
            if(this.vertices.get(i).getDado().equals(dado)){
                return i;
            }
        }
        return -1;
    }

    public void buscaLargura(String dado) { // O dado passado aqui é pra definir em qual vertice ira começar a busca
        int indexInicio = getVerticePosition(dado); // chama a rotina getVerticePosition pra pegar o i do dado que nos queremos começar
        if(indexInicio == -1){
            System.out.println("Vertice não encontrado.");
            return;
        }
        ArrayList<String> marcados = new ArrayList<>();
        ArrayList<String> fila = new ArrayList<>();
        String atual = vertices.get(indexInicio).getDado();
        marcados.add(atual);
        System.out.println(atual);
        fila.add(atual);
        while (fila.size() > 0) {
            String visitado = fila.get(0);
            for (int i = 0; i < vertices.size(); i++) {
                String proximo = vertices.get(i).getArestas().get(i).getB(); //visitado.getArestas().get(i).getB();
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    System.out.println(proximo);
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public void buscaProfundidade(String dado){
        int indexInicio = getVerticePosition(dado); // chama a rotina getVerticePosition pra pegar o i do dado que nos queremos começar
        if(indexInicio == -1){
            System.out.println("Vertice nao encontrado.");
            return;
        }
        marcados.add(vertices.get(indexInicio).getDado()); // Adiciona na lista de marcados
        for(int i=0; i< vertices.get(indexInicio).getArestas().size(); i++){ // Varre as arestas do vertice
            String proximo = vertices.get(indexInicio).getArestas().get(i).getB(); // Pega o proximo
            if(proximo.equals(vertices.get(indexInicio).getDado())) { // Caso o getB retorne o proprio vertice ele pega o getA, que seria o vizinho
                proximo = vertices.get(indexInicio).getArestas().get(i).getA();
            }
            if(!marcados.contains(proximo)){ // Se o vertice nao estiver marcado entra aqui
                System.out.println("|\nV\n" + proximo); // Explora
                buscaProfundidade(proximo); // Chama recursivamente com o dado sendo o proximo agora
            }
        }
    }

    /*public ArrayList<Aresta> AGM(String dado){
        int indexInicio = getVerticePosition(dado); // chama a rotina getVerticePosition pra pegar o i do dado que nos queremos começar
        if(indexInicio == -1){
            System.out.println("Vertice nao encontrado.");
            return new ArrayList<>();
        }
        ArrayList<Vertice> visitados = new ArrayList<>();
        ArrayList<Aresta> disponiveis = new ArrayList<>();
        ArrayList<Aresta> arestasUsadas = new ArrayList<>();
        visitados.add(vertices.get(indexInicio));
        disponiveis.addAll(vertices.get(indexInicio).getArestas());
        while(!disponiveis.isEmpty()){
            Aresta barato = new Aresta(disponiveis.get(0).getId(), disponiveis.get(0).getPeso(), disponiveis.get(0).getA(), disponiveis.get(0).getB() );
            for (int i=0; i < disponiveis.size(); i++){
                if(disponiveis.get(i).getPeso() < barato.getPeso()){
                    barato = disponiveis.get(i);
                }
            }
            if(visitados.contains(barato.getA())) {
                visitados.add(barato.getB());
                disponiveis.addAll(barato.getB().getArestas());
            }
            else {
                visitados.add(barato.getA());
                disponiveis.addAll(barato.getA().getArestas());
            }
            disponiveis.remove(barato);
            arestasUsadas.add(barato);
            for(int i=0; i<disponiveis.size(); i++){
                if(visitados.contains(disponiveis.get(i).getA()) && visitados.contains(disponiveis.get(i).getB())){
                    disponiveis.remove(i);
                }
            }

        }
        return arestasUsadas;
    }*/

    public boolean temCicloTres(){
        for (Vertice vertex : vertices) {
            for (int j = 0; j < vertex.getArestas().size(); j++) {
                int p = getVerticePosition(vertex.getArestas().get(j).getB());
                String proximo = vertex.getArestas().get(j).getB(); // Pega o proximo
                if (proximo.equals(vertex.getDado())) { // Caso o getB retorne o proprio vertice ele pega o getA, que seria o vizinho
                    proximo = vertex.getArestas().get(j).getA();
                    p = getVerticePosition(vertex.getArestas().get(j).getB());
                }
                for (int k = 0; k < vertices.get(p).getArestas().size(); k++) {
                    int x = getVerticePosition(vertices.get(p).getArestas().get(k).getB());
                    proximo = vertices.get(p).getArestas().get(k).getB(); // Pega o proximo
                    if (proximo.equals(vertices.get(p).getDado())) { // Caso o getB retorne o proprio vertice ele pega o getA, que seria o vizinho
                        proximo = vertices.get(p).getArestas().get(k).getA();
                        x = getVerticePosition(vertices.get(p).getArestas().get(k).getB());
                    }
                    for (int l = 0; l < vertices.get(x).getArestas().size(); l++) {
                        if (vertices.get(x).getArestas().get(l).getId().equals(vertex.getDado()))
                            return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean ehPlanar(){
        if(vertices.size()>=3){
            if(!temCicloTres()){
                return arestas.size() <= (2 * vertices.size()) - 4;
            }else{
                return arestas.size() <= (3 * vertices.size()) - 6;
            }
        }
        return true;
    }

    public ArrayList<Vertice> ordenaGrau(){
        ArrayList<Vertice> listaOrdenada = vertices;
        boolean trocou = false;
        do {
            for(int i=0; i< listaOrdenada.size()-1; i++){
                if(listaOrdenada.get(i).getArestas().size() < listaOrdenada.get(i+1).getArestas().size()){
                    Vertice aux = listaOrdenada.get(i);
                    listaOrdenada.set(i, listaOrdenada.get(i+1)) ;
                    listaOrdenada.set(i+1,aux);
                    trocou = true;
                }
            }
        }while(trocou);
        return listaOrdenada;
    }
    public boolean adjCor(ArrayList<Vertice> v, Vertice vi, int cor){
        //ArrayList<Vertice> adjacentes = new ArrayList<>();
        for (Vertice vertice : v) { // Varre todos os itens da lista de ja coloridos
            if (vertice.getCor() == cor) { // Se a cor do vertice i é igual a cor da rodada
                for (int j = 0; j < vertice.getArestas().size(); j++) { // varre todos os adjacentes de vertice i
                    String adj = vertice.getArestas().get(j).getB();
                    if (Objects.equals(adj, vertice.getDado())) {
                        adj = vertice.getArestas().get(j).getA();
                    }
                    int k = getVerticePosition(adj);
                    if (vertices.get(k) == vi)
                        return true; // Se nos adjacentes tiver o Vertice atual do welshPowell, o vertice eh adjacente a um vertice da msm cor
                }
            }
        }
        return false;
    }
    public ArrayList<Vertice> WelshPowell(){
        ArrayList<Vertice> verticeCor = new ArrayList<>(); // lista q vai retornar os vertices coloridos
        ArrayList<Vertice> listaOrdenada = ordenaGrau(); // lista ordenada por grau de adjacencia
        int cor = 0; // cores sao int pra ser mais facil de atribuir e comparar
        while(verticeCor.size() < listaOrdenada.size()){ // Faz o loop ate todos os vertices estarem coloridos
            cor++; // passa a cor
            for (Vertice vertice : listaOrdenada) { // varre todos os vertices
                if (vertice.getCor() == -1 && !adjCor(verticeCor, vertice, cor)) { // se ele nao tiver cor e nao for adjacente de nenhum vertice com a cor da rodada
                    vertice.setCor(cor); // colore o vertice
                    verticeCor.add(vertice);
                }
            }
        }
        return verticeCor;
    }

    public void calculaH(String destino){
        int indexDestino = getVerticePosition(destino);
        for (Vertice vertex : vertices) {
            double distanciaH = (Math.abs(vertex.getX() - vertices.get(indexDestino).getX()) + Math.abs(vertex.getY() - vertices.get(indexDestino).getY()));
            h.add(new VerticeH(vertex.getDado(), distanciaH));
        }
    }
    /*
    public Vertice obtemMelhorNodo(ArrayList<Vertice> op){
        Vertice melhor;
        for(int i=0; i<op.size();i++){
            for(int j=0; j<h.size();j++){
                if(op.get(i).getDado() == h.get(j).getDado()){

                }
            }
        }
        return melhor;
    }

    public ArrayList<Vertice> aStar(String inicio, String destino){
            h.clear();
            calculaH(destino);
            ArrayList<Vertice> opcoes = new ArrayList<>();
            ArrayList<Vertice> caminho = new ArrayList<>();
            String atual = inicio;
            do {
                caminho.add(obtemMelhorNodo(opcoes));
                if(obtemMelhorNodo(opcoes).getDado == destino)
                    return caminho;

            }while();
    }
    */
    public void mostra(){
        for (Vertice vertex : vertices) {
            if (!vertex.getArestas().isEmpty()) {
                System.out.print("Vertice " + vertex.getDado() + ": ");
                for (int j = 0; j < vertex.getArestas().size(); j++) {
                    if (Objects.equals(vertex.getDado(), vertex.getArestas().get(j).getA()))
                        System.out.print(vertex.getArestas().get(j).getB() + " ");
                    else
                        System.out.print(vertex.getArestas().get(j).getA() + " ");
                }
                System.out.print("\n");
            } else {
                System.out.print("Vertice " + vertex.getDado() + " eh isolado\n");
            }
            System.out.println("Vertice " + vertex.getDado() + " tem a cor " + vertex.getCor());
        }
    }
    public Graph<String, String> criaGrafo(){
        Graph<String, String> grafo = new UndirectedSparseGraph<>();
        if (vertices.size() == 0)
            throw new IllegalArgumentException("Não existem vertices!");
        else {
            for (Vertice vertex : vertices) {
                //System.out.println("");
                if (vertex.getArestas().size() == 0)
                    throw new IllegalArgumentException("O grafo não tem arestas!");
                else {
                    for (int j = 0; j < vertex.getArestas().size(); j++) {
                        grafo.addEdge(vertex.getArestas().get(j).getId(),
                                vertex.getArestas().get(j).getA(),
                                vertex.getArestas().get(j).getB());
                    }
                }
            }
        }
        return grafo;
    }
    public void visualizacao(){
        try {
            Graph<String, String> grafo = criaGrafo();
            ISOMLayout<String, String> layout = new ISOMLayout<>(grafo);
            VisualizationViewer<String, String> componente = new VisualizationViewer<>(layout);
            RenderContext<String, String> ctx = componente.getRenderContext();

            ctx.setVertexShapeTransformer(new TransformaFormaDosVertices());
            ctx.setVertexLabelTransformer(new TransformaRotulosDosVertices());
            ctx.setVertexFontTransformer(new TransformaFontesDosVertices());
            ctx.setVertexStrokeTransformer(new TransformaLinhasDosVertices());
            ctx.setVertexFillPaintTransformer(new TransformaPreenchimentoDosVertices());
            ctx.setVertexDrawPaintTransformer(new TransformaCorDasLinhasDosVertices());
            ctx.setVertexDrawPaintTransformer(new TransformaCorDasLinhasDasArestas());

            Renderer.VertexLabel<String, String> vl = componente.getRenderer().getVertexLabelRenderer();
            vl.setPosition(Renderer.VertexLabel.Position.CNTR);
            componente.setPreferredSize(new Dimension(640,640));
            componente.setBackground(Color.WHITE);

            JFrame f = new JFrame("Visualização de Grafos");
            f.getContentPane().add(componente);
            f.pack();
            f.setVisible(true);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
