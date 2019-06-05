/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        Vertice v1 = new Vertice(0, "v1");
        Vertice v2 = new Vertice(1, "v2");
        Vertice v3 = new Vertice(2, "v3");
        Vertice v4 = new Vertice(3, "v4");
        Vertice v5 = new Vertice(4, "v5");
        
// Exemplo ---> inserção de vertices       
//        Vertice exemplo = new Vertice(6, "bernado vieira com salgado filho");
//        exemplo.setLatitude("56");
//        exemplo.setLongitude("-5");
//        grafo.inserir_vertice(exemplo);

// Exemplo ---> inserção de arestas       
//        Aresta exemplo = new Aresta(2, vertice-1, vertice-2);
//        exemplo.setNome("Bernardo Vieira");
 //       grafo.inserir_aresta(exemplo);

        grafo.inserir_vertice(v1);
        grafo.inserir_vertice(v2);
        grafo.inserir_vertice(v3);
        grafo.inserir_vertice(v4);
        grafo.inserir_vertice(v5);
        
        Aresta a1 = new Aresta(10, v1, v2);
        //a1.setValue(10);
        Aresta a2 = new Aresta(100, v1, v5);
       // a2.setValue(100);
        Aresta a3 = new Aresta(60, v4, v5);
       // a3.setValue(60);
        Aresta a4 = new Aresta(20, v4, v3);
       // a4.setValue(20);
        Aresta a5 = new Aresta(50, v2, v3);
       // a5.setValue(50);
        Aresta a6 = new Aresta(10, v3, v5);
       // a6.setValue(10);
        Aresta a7 = new Aresta(30, v1, v4);
       // a7.setValue(30);
        
        grafo.inserir_aresta(a1);
        grafo.inserir_aresta(a2);
        grafo.inserir_aresta(a3);
        grafo.inserir_aresta(a4);
        grafo.inserir_aresta(a5);
        grafo.inserir_aresta(a6);
        grafo.inserir_aresta(a7);
        
        grafo.print();
        
        Dijkstra dijkstra = new Dijkstra(grafo);
        
        dijkstra.dijkstra(v1);
        
        Object[] pesos = dijkstra.getDists();
        Object[] vertices = dijkstra.getAntecessores();
        Object v;
        int j;
        System.out.println("\n--------------------");
        for(int i=0 ; i < 5; i++){
            v =  vertices[i];
            j = i+1;
            System.out.print("vertice v" + j);
            System.out.print("->Antecendente " + v);
            System.out.print(" -- ");
            System.out.print("peso " + pesos[i]);
            System.out.println("\n");
        }
             
    }
    
}
