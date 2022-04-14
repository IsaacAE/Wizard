/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;
import wizard.Archivo;
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
      Sistema sistema = new Sistema();
      Juego juego = new Juego();
      Tablero tablero = new Tablero();
      sistema.iniciar(); 
      /*Juego juego = new Juego();
      Tablero tablero = new Tablero();
      juego.agregarJugadores(new Jugador("Mauricio"));
      juego.agregarJugadores(new Jugador("Ruben"));
      juego.agregarJugadores(new Jugador("Joel"));
      Archivo ob = new Archivo();
      ob.Historial(juego, tablero);*/
    }
}
