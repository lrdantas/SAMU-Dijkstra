/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class LerArquivo {
    
    private Scanner x;
    private String entrada;
    private final String caminho = "Grafo/src/entrada/";
    private int num_vertices = 0;
   
    private List lista = new ArrayList();

    public LerArquivo(String entrada) {
        this.entrada = entrada;
    }
 
    public void abrirArquivo(String entrada){
        
        try {
            x = new Scanner(new File(caminho + entrada));
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado");
        }
 
    }
    
    public  void lerArquivo(){
        abrirArquivo(entrada);
        while (this.x.hasNext()) {
           num_vertices++;
           this.lista.add(this.x.nextLine());
     
        }
    }
    
    public void fechar(){
        x.close();
    }
    
    public void run(){
        abrirArquivo(entrada);
        lerArquivo();
        fechar();
    }

    public Scanner getX() {
        return x;
    }

    public List getLista() {
        return lista;
    }

    public int getNum_vertices() {
        return num_vertices;
    }    

}