/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class Grafo {
    
    private Object[][] grafo_custo;
    private int m;
    private int index_v = 0;
    private int index_a = 0;
    private int index_b = 0;
    private final List vertices = new ArrayList();
    
    private final int inf = Integer.MAX_VALUE /2;

    public Grafo(int m) {
        this.m = m;
        this.grafo_custo =  new Object[m][m];
        for(int i=0; i< m; i++){
            for(int j=0;j<m;j++){
                this.grafo_custo[i][j] = inf;
            }
        }
    }

    public Object[][] getGrafo_custo() {
        return grafo_custo;
    }

    public void setGrafo_custo(Object[][] grafo_custo) {
        this.grafo_custo = grafo_custo;
    }
    
    public void inserir_vertice(Vertice v){
        index_v = v.getKey();
        grafo_custo[index_v][index_v] = 0;
        vertices.add(v);
    }
    
    public void inserir_aresta(Aresta a){
        index_a = a.getV1().getKey();
        index_b = a.getV2().getKey();
        
        grafo_custo[index_a][index_b] = a.getValue();
        
    }
    //retorna indices dos vertices
    public List arestas_incidentes(Vertice v){
        List lista = new ArrayList();
        index_v = v.getKey();
        for(int i=0; i< m; i++){
            int value = (int) grafo_custo[index_v][i];
            if(value < inf && value != 0)
                lista.add(i);
        }
        return lista;
    }
    
    public List getVertices() {
        return vertices;
    }
    
    
    public void print(){
        
        for(int i=0; i< m; i++){
            System.out.println(" \n");
            for(int j=0;j<m;j++){
                System.out.print("  " + this.grafo_custo[i][j]);
            }
        }
    }
        

}
