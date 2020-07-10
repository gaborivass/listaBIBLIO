package biblioteca;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

class lista{
    nodo f;
    nodo primero;
    nodo segundo;
    
    
    String lee1;
    String lee2;
    
    
    
    public void hacer ( String x , String y ){
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
            System.out.println(i + ":" + primero.apellido);
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
       System.out.println("empezamos la ronda de lectura numero " + k + " y pasa a leer: "+""+ primero.prox.nombre);
      lee1 = ("Ronda "+ k + " lee "+ primero.prox.nombre);
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
    System.out.println("empezamos la ronda de lectura numero " + k + " y pasa a leer: "+ ""+ primero.prev.apellido);
      lee2 = ("Ronda "+ k + " lee "+ primero.prev.apellido);
      primero.prev = primero.prev.prev;
      segundo = primero.prev;
      
      if (vol == ale1){
          f = segundo.prox.prox;
       }
      segundo.prox =  segundo.prox.prox;
      return lee2;
 } 
}

public class Biblioteca {
    public static void main(String[] args) throws IOException {
     lista lis = new lista ();
     Scanner leer = new Scanner(System.in);
     String L;
     int cantidad = 0;
    
     FileReader filer = new FileReader("lectores.in.txt");
     BufferedReader buffer = new BufferedReader(filer);
     FileWriter filew = new FileWriter("lectores.out.txt");
     BufferedWriter buffew = new BufferedWriter(filew);
     
      while((L = buffer.readLine())!=null){
            cantidad++;
        }
        System.out.println("¡B I E N V E N I D O S   A   L A   B I B L I O T E C A!");
         System.out.println("");
        System.out.println("la actividad cuenta con  " + cantidad + " niños registrados, que pasaran a leer cuando los bibliotecarios elijan\n"+"Esta practica actividad se lleva acabo de la siguiente manera :El primer bibliotecario elige de una manera aleatoriamente en sentido horario\n"+""+"El segundo elige de la misma manera pero en sentido antihorario.");
        
        filer = new FileReader("lectores.in.txt");
        buffer = new BufferedReader(filer);
        
            for (int i = 0; i < cantidad ; i++) {
            String ray = buffer.readLine();
            String[] dato = ray.split("/n");
             System.out.println("");
            
         int x = 0;
         int y = 0;
            lis.hacer(dato[x], dato[y]);
        }
            
        int rondas  = 1;
         System.out.println("Los niños son: ");
          System.out.println("");
        lis.mostrar(cantidad);
        
         while(cantidad !=0) {
            String i = "";
            String u = "";
            int bb1 = (int)(Math.random()*cantidad+1);
            int bb2 = (int)(Math.random()*cantidad+1);
            System.out.println("");
            System.out.println("EMPEZAREMOS LA " + rondas + " RONDA CON UN SELECTOR ALEATORIO SOBRE LOS NIÑOS QUE PASARAN A LEER");
            System.out.println("");
            System.out.println("(❛̃ ͜ʖ❛̃) 👉  El bibliotecario uno, da a conocer que el niño que pasara a leer es el numero: "+ bb1);
            System.out.println("");
            System.out.println("( ❛ ͜ʖ ❛ ) 👉 El bibliotecario dos, da a conocer que el niño que pasara a leer es el numero: "+ bb2);
            System.out.println("");
            if ((bb1 + bb2)==(cantidad+1)){
                
                i = lis.biblio1(cantidad,bb1,rondas);
                cantidad--;
                buffew.write(i);
                buffew.newLine();
            } else {
                
                i = lis.biblio1(cantidad,bb1,rondas);
                cantidad--;
                u = lis.biblio2(cantidad, bb2,bb2, rondas);
                cantidad--;
                buffew.write(i);
                buffew.newLine();
                buffew.write(u);
                buffew.newLine();
            }
            if(cantidad!=0){
                System.out.println("");
                lis.mostrar(cantidad);
            
            } else {
               System.out.println("¡⬆⬆⬆⬆⬆⬆     ULTIMO NIÑO LECTOR    ⬆⬆⬆⬆⬆⬆!");
               System.out.println("");
               System.out.println("¡✌TERMINAMOS LA ACTIVIDAD, NO QUEDAN NIÑOS POR LEER✌!");
               System.out.println("");
               System.out.println("░█████╗░██████╗░███████╗░█████╗░████████╗███████╗  ██████╗░██╗░░░██╗██╗\n" +
"██╔══██╗██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██╔════╝  ██╔══██╗╚██╗░██╔╝╚═╝\n" +
"██║░░╚═╝██████╔╝█████╗░░███████║░░░██║░░░█████╗░░  ██████╦╝░╚████╔╝░░░░\n" +
"██║░░██╗██╔══██╗██╔══╝░░██╔══██║░░░██║░░░██╔══╝░░  ██╔══██╗░░╚██╔╝░░██╗\n" +
"╚█████╔╝██║░░██║███████╗██║░░██║░░░██║░░░███████╗  ██████╦╝░░░██║░░░╚█║\n" +
"░╚════╝░╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝  ╚═════╝░░░░╚═╝░░░░╚╝\n" +
"\n" +
"░██████╗░░█████╗░██████╗░░█████╗░██████╗░██╗██╗░░░██╗░█████╗░░██████╗░██████╗\n" +
"██╔════╝░██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║██║░░░██║██╔══██╗██╔════╝██╔════╝\n" +
"██║░░██╗░███████║██████╦╝██║░░██║██████╔╝██║╚██╗░██╔╝███████║╚█████╗░╚█████╗░\n" +
"██║░░╚██╗██╔══██║██╔══██╗██║░░██║██╔══██╗██║░╚████╔╝░██╔══██║░╚═══██╗░╚═══██╗\n" +
"╚██████╔╝██║░░██║██████╦╝╚█████╔╝██║░░██║██║░░╚██╔╝░░██║░░██║██████╔╝██████╔╝\n" +
"░╚═════╝░╚═╝░░╚═╝╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚═════╝░╚═════╝░");
            }
            rondas = rondas + 1;
            
        } 
        
         buffew.close();
    }
    
    
}
