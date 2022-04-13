/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;
import wizard.src.Baraja;
import wizard.src.Jugador;
import wizard.src.Estructuras.*;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
public class Main{


 /* public static boolean validarMov(Carta carta){

  }*/

 /* public static Carta jugarCarta(Lista<Carta> mano){

  }*/

  public static Jugador solicitarDatos(){
    Scanner escaner = new Scanner(System.in);
    boolean valido = false;
    String nombre = "";
    do{
      valido=true;
      System.out.println("Escribe tu nombre");
       try{
      
      nombre=escaner.nextLine();
          }catch(InputMismatchException et){
      
           valido=false;
           escaner.next();
       }

  }while(valido==false);
   Jugador jugadorNuevo = new Jugador(nombre);
  return jugadorNuevo;
}

public static Lista<Jugador> crearJugadores(){
  Scanner escaner = new Scanner(System.in);
    boolean valido = false;
    int jugadores = 0;
  do{
    valido=true;
    System.out.println("Escribe el numero de jugadores");
     try{
    
    jugadores=escaner.nextInt();
    if(jugadores<3 || jugadores> 6) valido=false;
        }catch(InputMismatchException et){
    
         valido=false;
         escaner.next();
     }

}while(valido==false);

Lista<Jugador> totalJugadores = new Lista<>();
for(int i =0; i<jugadores; i++){
  totalJugadores.add(solicitarDatos());
}
return totalJugadores;
}
    
    public static void main(String[] args){    
      /*Tablero tablero = new Tablero();
      Juego juego = new Juego();
      juego.agregarJugadores(new Jugador("Mauricio"));
      juego.agregarJugadores(new Jugador("Ruben"));
      Iterator<Jugador> iteradorLista = juego.jugadores.iterator();
      tablero.barajita = iteradorLista.next().barajear(tablero.barajita);
      System.out.println("Baraja lenght -->"+tablero.barajita);
      juego.setJugadores(tablero.repartir(10, juego.getJugadores()));
      juego.mostrarJugadores();
      System.out.println("Baraja lenght -->"+tablero.barajita);*/
      Sistema sistema = new Sistema();
      Scanner escaner = new Scanner(System.in);
      Juego juego = new Juego();
      Jugador juan = new Jugador("juan");
      juego.jugadores.add(juan);
      Tablero tablero = new Tablero();
      //Jugador jugadorP = juego.jugadores.peek();
     // Baraja barajaP = jugadorP.barajear(tablero.getBarajita());
     
      sistema.iniciar();
 
       
      
 



  /* for(int i = 1; i<10; i++){
        lista.add(i);
    }*/

    
  //  a.cambiarCarta(0, 11);
  //  d.revolver();

    /*for(int k =1; k<lista.longi; k++){
      System.out.print("   "+k);
    }
   Carta oops = jg.jugarCarta(jg.getMano(), 2);
    Baraja mazoP= new Baraja();
    System.out.println("Mostrando mano \n"+jg.mostrarMano());
    System.out.println(oops.toString());
    
  System.out.println(mazoP.toString());
  mazoP.revolver();
  System.out.println(mazoP.toString());

  Lista<Jugador> jugadores = crearJugadores();
   
  System.out.println(jugadores.toString());*/
  /*for(int i=0; i<jugadores.length; i++){
    System.out.println(jugadores[i].toString());
  }*/
  //System.out.println(jugador1.toString());

  /*Carta aux = new Carta("neutro", "2");
  Carta[] ojo = mazoP.getMazoCartas();
    for(int k = 0; k<ojo.length; k++){
       aux = mazoP.sacarCarta();
        System.out.println(aux.toString());
    }*/

 // Carta[] aux = mazoP.getMazoCartas();
 //BORRABLE
 /*int j = 0;
 Carta[] hope = a.getMazoCartas();
  for( int i = 0; i<hope.length;i++){
        aux[j]= a.getMazoCartas()[i];
        j++;
  }
System.out.println(j);
  Carta[] pope= b.getMazoCartas();
  for( int i = 0; i<pope.length;i++){
        aux[j]= b.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);
  Carta[] rope = c.getMazoCartas();
  for( int i = 0; i<rope.length;i++){
        aux[j]= c.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);

  Carta[] lope = d.getMazoCartas();
  for( int i = 0; i<lope.length;i++){
        aux[j]= d.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);
  Carta[] tope = e.getMazoCartas();
  for( int i = 0; i<tope.length;i++){
        aux[j]= e.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);
  Carta[] yope = f.getMazoCartas();
  for( int i = 0; i<yope.length;i++){
        aux[j]= f.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);

  System.out.println(j);
  for( int i = 0; i<aux.length;i++){
    System.out.print(aux[i].toString());
  }

*/
//FIN BORRABLE
   // System.out.println(red.toString());
    }

    
}
