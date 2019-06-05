/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Luis
 */
public class Dijkstra {
    
    private Object[] antecessores;
    private Object[] dists;
    private List nuvem = new ArrayList();
    private int size;

    private Grafo grafo_custo;

    public Dijkstra(Grafo grafo_custo) {
        this.grafo_custo = grafo_custo;
        this.size = grafo_custo.getVertices().size();
        this.antecessores = new Object[this.size];
        this.dists = new Object[this.size];
    }

    public Object[] getAntecessores() {
        return antecessores;
    }

    public Object[] getDists() {
        return dists;
    }
    
    public void dijkstra(Vertice v){
        
        Vertice ant;
        Vertice w = v;
        int value_a = 0;
        int value_b = 0;
        List vertices = grafo_custo.getVertices();
        this.size = vertices.size();
        int dw = 0;
        Object[][] grafo = grafo_custo.getGrafo_custo();
        while(!vertices.isEmpty()){
            if(nuvem.isEmpty()){
                for(int i = 0 ; i < this.size; i++){
                    this.antecessores[i] = w.getValue();
                    this.dists[i] = grafo[w.getKey()][i];                  
                }
                vertices.remove(w);
                nuvem.add(w);
            }
            
            else{
                Iterator iterator = vertices.iterator();
                while(iterator.hasNext()){
                    ant = (Vertice) iterator.next();
                    value_a = (int) this.dists[ant.getKey()];
                    value_b = (int) grafo[w.getKey()][ant.getKey()] + dw;
                    if(value_a > value_b){
                        this.dists[ant.getKey()] = value_b;
                        this.antecessores[ant.getKey()] = w.getValue();
                    }
         
                }
               
                w = min(vertices); 
                dw = (int) this.dists[w.getKey()];
                vertices.remove(w);
                nuvem.add(w);
           
            }
        }  
    }
       
    private Vertice min(List lista){
        int value = Integer.MAX_VALUE;
        int value_d = 0;
        Vertice v_temp = null;
        Vertice v_return = null;
        for(int i = 0 ; i < lista.size(); i++){
            v_temp = (Vertice) lista.get(i);
            value_d = (int) dists[v_temp.getKey()];
            if(value_d < value){
                value = value_d;
                v_return = (Vertice) grafo_custo.getVertices().get(i);
            }
        }
        return v_return;
    }  
    
}
