package GrafoDirigido;

import java.util.ArrayList;
import java.util.Objects;

public class GrafoD{

    private final ArrayList<Vertice> vertices;
    private final ArrayList<Arco> arcos;
    private final ArrayList<Vertice> marcados;

    public GrafoD(){
        this.vertices = new ArrayList<>();
        this.arcos = new ArrayList<>();
        this.marcados = new ArrayList<>();
    }

    public void adicionaVertice(String dado){
        Vertice novoV = new Vertice(dado);
        this.vertices.add(novoV);
    }

    public void removeVertice(String dado){
        for(int i=0;i<vertices.size();i++){
            if(vertices.get(i).getDado().equals(dado)){
                vertices.get(i).removeTodosArcosEntrada();
                vertices.get(i).removeTodosArcosSaida();
                vertices.remove(i);
            }
        }
    }

    public void adicionaArco(String dadoSaida, String dadoChegada){
        Vertice saida = this.buscaVertice(dadoSaida);
        Vertice chegada = this.buscaVertice(dadoChegada);
        Arco arco = new Arco(1.0,saida.getDado(),chegada.getDado());
        saida.adicionaArcoSaida(arco);
        chegada.adicionaArcoEntrada(arco);
        this.arcos.add(arco);
    }

    public void removeArcoG(String inicio, String fim){
        for(int i=0; i<arcos.size(); i++){
            if(arcos.get(i).getInicio().equals(inicio) && arcos.get(i).getFim().equals(fim)){
                //arcos.get(i).getInicio().removeArco(arcos.get(i).getFim().getDado());
                arcos.remove(i);
            }
        }
    }

    public Vertice buscaVertice(String dado){ // Retorna o objeto Vertice que contem o "dado" dentro dele
        Vertice vertice = null;
        for (Vertice vertex : this.vertices) {
            if (Objects.equals(vertex.getDado(), dado)) {
                vertice = vertex;
                break;
            }
        }
        return vertice;
    }

    public int getVerticePosition(String dado){ // A partir do dado do vertice busca qual indice ele ta na lista
        for(int i=0; i < this.vertices.size(); i++){
            if(this.vertices.get(i).getDado().equals(dado)){
                return i;
            }
        }
        return -1;
    }

    public void buscaLargura(String dado){ // O dado passado aqui é pra definir em qual vertice ira começar a busca
        int indexInicio = getVerticePosition(dado); // chama a rotina getVerticePosition pra pegar o i do dado que nos queremos começar
        if(indexInicio == -1){
            System.out.println("Vertice nao encontrado.");
            return;
        }
        ArrayList<String> marcados = new ArrayList<>();
        ArrayList<String> fila = new ArrayList<>();
        String atual = this.vertices.get(indexInicio).getDado();
        marcados.add(atual);
        System.out.println(atual);
        fila.add(atual);
        while(fila.size() > 0){
            String visitado = fila.get(0);
            for(int i=0 ; i < vertices.size(); i++){
                String proximo = vertices.get(i).getArcosSaida().get(i).getFim();
                if(!marcados.contains(proximo)){
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
        marcados.add(vertices.get(indexInicio));
        for(int i = 0; i< vertices.get(indexInicio).getArcosSaida().size(); i++){ // Varre todos os arcos de saida do vertice
            if(!marcados.contains(vertices.get(indexInicio).getArcosSaida().get(i).getFim())){
                System.out.print(" -> " + vertices.get(indexInicio).getArcosSaida().get(i).getFim());
                buscaProfundidade(vertices.get(indexInicio).getArcosSaida().get(i).getFim());
            }
        }
    }

    /*public ArrayList<Arco> AGM(String dado){
        int indexInicio = getVerticePosition(dado); // chama a rotina getVerticePosition pra pegar o i do dado que nos queremos começar
        if(indexInicio == -1){
            System.out.println("Vertice nao encontrado.");
            return new ArrayList<Arco>(); // retorna um arraylist vazio
        }
        ArrayList<Vertice> visitado = new ArrayList<Vertice>();
        ArrayList<Arco> arcosDisponiveis = new ArrayList<Arco>();
        ArrayList<Arco> arcosUsados = new ArrayList<Arco>();
        visitado.add(vertices.get(indexInicio));
        arcosDisponiveis.addAll(vertices.get(indexInicio).getArcosSaida());
        while(!arcosDisponiveis.isEmpty()){
            Arco barato = new Arco(arcosDisponiveis.get(0).getPeso(),arcosDisponiveis.get(0).getInicio(),arcosDisponiveis.get(0).getFim());
            for(int i=0; i<arcosDisponiveis.size();i++){ // Verifica todas as arestas disponiveis e pega a mais barata.
                if (arcosDisponiveis.get(i).getPeso() > barato.getPeso()){
                    barato = arcosDisponiveis.get(i);
                }
            }
            visitado.add(barato.getFim()); // Marca o vertice chegado como visitado
            arcosDisponiveis.remove(barato); // Tira o arco usado dos disponiveis
            arcosUsados.add(barato); // Coloca o arco usado na lista
            for(int i=0; i<arcosDisponiveis.size(); i++){ // Verifica se ja chegou em dois vertices com um arco nao usado ligando eles, e descarta o arco.
                if(visitado.contains(arcosDisponiveis.get(i).getInicio()) && visitado.contains(arcosDisponiveis.get(i).getFim())){
                    arcosDisponiveis.remove(i);
                }
            }
        }
        return arcosUsados; // Retorna o arraylist com os arcos usados, e neles tem o caminho e o peso de tudo
    }*/

    public void mostra(){
        for (Vertice vertex : vertices) {
            if (!vertex.getArcosSaida().isEmpty()) {
                System.out.print("Vertice " + vertex.getDado() + ": ");
                for (int j = 0; j < vertex.getArcosSaida().size(); j++) {
                    System.out.print(vertex.getArcosSaida().get(j).getFim() + " ");
                }
                System.out.print("\n");
            } else {
                System.out.print("Vertice " + vertex.getDado() + " não tem arcos de saida");
            }
        }
    }
}
