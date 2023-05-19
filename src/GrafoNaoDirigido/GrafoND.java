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
    //Atributos
    private final ArrayList<Vertice> vertices;
    private final ArrayList<Aresta> arestas;
    private final ArrayList<String> marcados;
    private final ArrayList<VerticeH> distanciaEstimada;

    //Construtor
    public GrafoND(){
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.marcados = new ArrayList<>();
        this.distanciaEstimada = new ArrayList<>();
    }

    //Vertice
    public void adicionaVertice(String dado, double x, double y){
        Vertice novoV = new Vertice(dado,x,y);
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

    //Aresta
    public void adicionaAresta(String dadoV, String dadoV1, String dadoA, double p){
        boolean existeA = existeVertice(dadoV);
        boolean existeB = existeVertice(dadoV1);
        if (existeA){
            if (existeB){
                Aresta a = new Aresta(dadoA, p, dadoV, dadoV1);
                Vertice v = buscaVertice(dadoV);
                Vertice v1 = buscaVertice(dadoV1);
                v.adicionaAresta(a);
                v1.adicionaAresta(a);
                arestas.add(a);
            }else System.out.println("Vertice " + dadoV1 + " não existe!");
        }else System.out.println("Vertice " + dadoV + " não existe!");
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
    }

    //Existe
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

    //Metodos T1
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

    //Planar
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

    //WelshPowell
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

    //A-Estrela
    public void calculaH(String destino){
        distanciaEstimada.clear(); // Limpa a "tabela" H, com a distancia em linha reta
        int indexDestino = getVerticePosition(destino);
        for (Vertice vertex : vertices) {
            double distanciaH = 100 * (Math.abs(vertex.getX() - vertices.get(indexDestino).getX()) + Math.abs(vertex.getY() - vertices.get(indexDestino).getY()));
            distanciaEstimada.add(new VerticeH(vertex.getDado(), distanciaH));
        }
        System.out.println(distanciaEstimada.size());
        for (VerticeH verticeH : distanciaEstimada) {
            System.out.println(verticeH.getDado() + " " + verticeH.getDistanciaH());
        }
    }
    public ArrayList<Vertice> expande(Vertice v, ArrayList<Vertice> c){
        ArrayList<Vertice> adjacentes = new ArrayList<>(); // Cria a lista que vai retornar
        for(int i=0; i<v.getArestas().size(); i++){ // Para todos os adjacentes de v
            String adj = v.getArestas().get(i).getB(); // adj recebe o fim B da aresta analisada
            if(Objects.equals(adj, v.getDado())){ // se esse B for o vertice de onde saiu
                adj = v.getArestas().get(i).getA(); // pega o fim A da aresta
            }
            adjacentes.add(vertices.get(getVerticePosition(adj))); // adiciona o vertice adjacente na lista de adjacentes
        }
        for(int i=0; i<adjacentes.size();i++){ // para todos os possiveis adjacentes
            if(c.contains(adjacentes.get(i))){ // se eles ja foram caminhados
                adjacentes.remove(i); // remove ele da lista
            }
        }
        return adjacentes; // retorna a lista de adjacentes
    }
    public int getIndiceH(String s){
        for(int i=0; i < this.distanciaEstimada.size(); i++){
            if(this.distanciaEstimada.get(i).getDado().equals(s)){
                return i;
            }
        }
        return -1;
    }
    public double precoAteAqui(ArrayList<Vertice> c){
        double soma = 0; // começa com 0
        ArrayList<Vertice> temp = c; // usa o temp como uma lista temporaria
        while(temp.size() != 0){ // enquanto tiver gente em temp
            for(int i=0; i<temp.get(0).getArestas().size(); i++){ // pega o primeiro da lista
                if(temp.get(1).equals(temp.get(0).getArestas().get(i).getA()) ||  temp.get(1).equals(temp.get(0).getArestas().get(i).getB()) ){ // se o proximo da lista for adjacente dele
                    soma = soma + temp.get(0).getArestas().get(i).getPeso(); // adiciona o valor da ligação a soma
                    temp.remove(0); // remove o primeiro da lista
                }
            }
        }

        return soma; // retorna a soma
    }
    public double calculaFn(Vertice v, ArrayList<Vertice> c){
        for(int i=0; i<v.getArestas().size();i++){
            if(c.get(c.size()-1).equals(v.getArestas().get(i).getA()) ||  c.get(c.size()-1).equals(v.getArestas().get(i).getB()) ){ // se ele tem ligação com o ultimo adicionado
                return (precoAteAqui(c) + v.getArestas().get(i).getPeso()) + distanciaEstimada.get(getIndiceH(v.getDado())).getDistanciaH(); // retorna o f(n) dele
            }
        }
        return 99999999; // se nao tem retorna um valor altissimo pra descartar
    }
    public Vertice obtemMelhorNodo(ArrayList<Vertice> nodos, ArrayList<Vertice> caminho,Vertice destino){
        Vertice melhor = nodos.get(0); // O melhor inicialmente eh a primeira opcao
        double fnMelhor = calculaFn(nodos.get(0), caminho); // calcula o f(n)
        for (Vertice nodo : nodos) { // para todas as opcoes
            if (nodo.getArestas().size() > 1 || destino.equals(nodo)) { // Se o vertice tiver mais caminho pela frente, ou for o destino
                double fn = calculaFn(nodo, caminho); // pega o f(n) do nodo atual
                if (fn < fnMelhor) { // se o novo for mais barato que o melhor
                    fnMelhor = fn; // o novo melhor eh o atual
                    melhor = nodo; // o melhor vertice eh o atual
                }
            }
        }
        return melhor; // retorna o melhor
    }
    public ArrayList<Vertice> aStar(String inicio, String destino){
        calculaH(destino); // calcula baseada em quem eh o destino
        Vertice inicial = vertices.get(getVerticePosition(inicio)); // guarda vertice inicial
        Vertice Vdestino = vertices.get(getVerticePosition(destino)); // guarda o vertice final
        ArrayList<Vertice> caminho = new ArrayList<>(); // cria a lista q vai retornar com o caminho feito
        caminho.add(inicial); // Adiciona o inicio no caminho
        ArrayList<Vertice> nodos = expande(inicial, caminho); // Adiciona na lista de opções os adjacentes do primeiro nodo
        System.out.println(nodos.size());
        while(nodos.size()!=0){ // enquanto tiver opcoes
            Vertice melhorNodo = obtemMelhorNodo(nodos,caminho,Vdestino); // pega o melhor nodo da lista de opcoes
            caminho.add(melhorNodo); // adiciona o melhor nodo na lista do caminho
            nodos.remove(melhorNodo); // remove o melhor nodo das opcoes
            if(caminho.contains(Vdestino)) break; // se ja achou o destino para o loop
            ArrayList<Vertice> novosNodos = expande(melhorNodo,caminho); // adiciona as opcoes os adjacentes do nodo escolhido
            nodos = novosNodos;
        }
        return caminho; // retorna a lista com o caminho
    }

    //Mostra o Grafo
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
            ctx.setVertexDrawPaintTransformer(new TransformaCorDasLinhasDosVertices());
            ctx.setEdgeDrawPaintTransformer(new TransformaCorDasLinhasDasArestas());

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
