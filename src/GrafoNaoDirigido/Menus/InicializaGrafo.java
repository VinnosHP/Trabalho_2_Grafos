package GrafoNaoDirigido.Menus;

import GrafoNaoDirigido.GrafoND;

public class InicializaGrafo {
    /*public InicializaGrafo(GrafoND grafo){
        grafo.adicionaVertice("Curitiba",-25.4284,-49.2733);
        grafo.adicionaVertice("Paranaguá",-25.5205,-48.5095);
        grafo.adicionaVertice("Ponta Grossa",-25.0945,-50.1633);
        grafo.adicionaVertice("Guarapuava",-25.3935,-51.4562);
        grafo.adicionaVertice("Londrina",-23.2927,-51.1732);
        grafo.adicionaVertice("Maringá",-23.4273,-51.9375);
        grafo.adicionaVertice("São Mateus do Sul",-25.8767,-50.3842);
        grafo.adicionaVertice("Umuarama",-23.7641,-53.3184);
        grafo.adicionaVertice("Francisco Beltrão",-26.0783,-53.0531);
        grafo.adicionaVertice("Toledo",-24.7199,-53.7433);
        grafo.adicionaVertice("Cascavel",-24.9555,-53.4552);
        grafo.adicionaVertice("Foz do Iguaçu",-25.54698,-54.5882);
        //Adicionando as arestas
        grafo.adicionaAresta("Paranaguá",         "Curitiba",         "PC",90);
        grafo.adicionaAresta("Curitiba",          "Ponta Grossa",     "CP",114);
        grafo.adicionaAresta("Curitiba",          "São Mateus do Sul","CS",157);
        grafo.adicionaAresta("Ponta Grossa",      "Londrina",         "PL",273);
        grafo.adicionaAresta("Ponta Grossa",      "Maringá",          "PM",314);
        grafo.adicionaAresta("Ponta Grossa",      "Guarapuava",       "PG",165);
        grafo.adicionaAresta("São Mateus do Sul", "Francisco Beltrão","SF",354);
        grafo.adicionaAresta("Londrina",          "Maringá",          "LM",114);
        grafo.adicionaAresta("Maringá",           "Umuarama",         "MU",190);
        grafo.adicionaAresta("Umuarama",          "Toledo",           "UT",126);
        grafo.adicionaAresta("Guarapuava",        "Cascavel",         "GC",250);
        grafo.adicionaAresta("Francisco Beltrão", "Cascavel",         "FC",186);
        grafo.adicionaAresta("Toledo",            "Cascavel",         "TC",50);
        grafo.adicionaAresta("Cascavel",          "Foz do Iguaçu",    "CF",143);
    }*/
    public InicializaGrafo(GrafoND grafo){
        grafo.adicionaVertice("A",50,50);
        grafo.adicionaVertice("B",100,50);
        grafo.adicionaVertice("C",100,100);
        grafo.adicionaVertice("D",50,100);

        grafo.adicionaAresta("A","B","1",1);
        grafo.adicionaAresta("B","C","2",1);
        grafo.adicionaAresta("C","D","3",1);
        grafo.adicionaAresta("D","A","4",1);
    }
}
