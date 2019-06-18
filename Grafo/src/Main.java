/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */

import entrada.LerArquivo;
import grafo.Aresta;
import grafo.Dijkstra;
import grafo.Grafo;
import grafo.Vertice;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Grafo grafo;
        
        LerArquivo arquivo = new LerArquivo("vertices");
        arquivo.run();
        List lista_vertices = arquivo.getLista();
        grafo = new Grafo(arquivo.getNum_vertices());
        
        arquivo = new LerArquivo("arestas");
        arquivo.run();
        List lista_arestas = arquivo.getLista();
        
        //Variaveis de controle:
        Vertice v;
        Aresta a;
        String linha;
        String[] valores;
        StringBuilder strName = new StringBuilder();
        strName.append("v");
        int key_a;
        int key_b;
        Vertice va;
        Vertice vb;
        
        //Inserir vertices no grafo de custo.
        for(int i = 0; i < lista_vertices.size() ; i++){
            linha = (String) lista_vertices.get(i);
            valores = linha.split(" ");
            strName = new StringBuilder();
            strName.append("v").append(valores[2]);
            
            v = new Vertice(Integer.parseInt(valores[2]), strName);
            v.setLatitude(valores[0]);
            v.setLongitude(valores[1]);
            grafo.inserir_vertice(v);            
        }
        
         //Inserir arestas no grafo de custo.
         for(int i = 0; i < lista_arestas.size() ; i++){
              linha = (String) lista_arestas.get(i);
              valores = linha.split(" ");
              key_a = Integer.parseInt(valores[0]);
              va = (Vertice) grafo.getVertices().get(key_a);
              key_b = Integer.parseInt(valores[1]);
              vb = (Vertice) grafo.getVertices().get(key_b);
              
              a = new Aresta(Integer.parseInt(valores[2]), va , vb);
              grafo.inserir_aresta(a);
              a = new Aresta(Integer.parseInt(valores[2]), vb , va);
              grafo.inserir_aresta(a);
         }
         
         Dijkstra dijkstra = new Dijkstra(grafo);
         
         Object[] vertices = grafo.getVertices().toArray();
         
         
         int peso;
         int resultado = 100000000;
         Vertice escolhido = null;
         Object[] dist;
         String valor;
         
         //Rodando dijkstra
         for(int i = 0; i < vertices.length; i++){  
             peso = 0;
             Vertice vert = (Vertice) vertices[i];
             dijkstra.dijkstra(vert);
             dist = dijkstra.getDists();
   
              for (Object d : dist) {
                  valor = d.toString();
                  //System.out.println(valor);
                  //if(Integer.parseInt(valor) > peso)
                  
                  peso = peso + Integer.parseInt(valor);
              }
             System.out.println(vert.getValue() + " com peso médio: " + peso/dist.length);
             if(resultado > peso/dist.length){
                 resultado = peso/dist.length;
                 escolhido = vert;
             }
         }
         
         //print resultado
         System.out.println("----------------------------------------------------------------------");
         System.out.println("---------------------------Resultado----------------------------------");
         System.out.println("Ambulância deverá está posicionada no vertice: " + escolhido.getValue());
         System.out.println("Latitude: " + escolhido.getLatitude());
         System.out.println("Longitude: " + escolhido.getLongitude());
         System.out.println("----------------------------------------------------------------------");

        
    }
    
}