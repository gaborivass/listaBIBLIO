/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
import java.io.*;
import java.util.Scanner;


class lista{
    nodo f;
    nodo primero;
    nodo segundo;
    
    
    String lee1;
    String lee2;
    
    
    
    public void hacer ( String x , String y , String z){
        if (f == null){
         f = new nodo(x,y);
         f.prox = f;
         f.prev = f;
        }
        else {
            primero = f;
            while (primero.prox!=f){
                primero = primero.prox;
            }
            primero.prox = new nodo(x,y);
            primero.prox.prox=f;
            segundo = f;
            segundo.prev = primero.prox;
            segundo.prev.prev = primero;
            }
        
    }
    
    void mostrar ( int m){
        primero = f;
        int i = 1;
        
        do{
            System.out.println(i + " " + m + primero.nombre + "" + primero.apellido);
            primero = primero.prox;
            i++;
            m--;
        } while ( primero != f);
            
    }
    
   String biblio1(int i, int j, int k){
       primero = f;
       if (j ==1){
           j= i + 1;
       }
       for (int r = 1; r < j - 1; r++) {
           primero = primero.prox;
          }
       System.out.println("empezamos la ronda de lectura numero" + k + " y pasa a leer "+ primero.prox.nombre+ ""+ primero.prox.apellido);
      lee1 = ("Ronda"+ k + "lee"+ primero.prox.nombre+""+ primero.prox.apellido);
      if (j== i + 1){
          f = primero.prox.prox;
      }
      primero.prox = primero.prox.prox;
      segundo = primero.prox;
      segundo.prev = segundo.prev.prev;
      return lee1;
   } 
 String biblio2(int vol, int ale1, int ale2,int k){
   primero = f;
   
   if (ale1+ale2>vol){
       ale1--;
   }
   for ( int i = 0; i < ale1-1; i++){
       primero = primero.prev;
   }
    System.out.println("empezamos la ronda de lectura numero" + k + " y pasa a leer "+ primero.prev.nombre+ ""+ primero.prev.apellido);
      lee2 = ("Ronda"+ k + "lee"+ primero.prev.nombre+""+ primero.prev.apellido);
      primero.prev = primero.prev.prev;
      segundo = primero.prev;
      
      if (vol == ale1){
          f = segundo.prox.prox;
       }
      segundo.prox =  segundo.prox.prox;
      return lee2;
 } 
}
/**
 *
 * @author Usuario
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
