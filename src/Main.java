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


/** 
 * Metodo main para ejecutar el programa y jugar al juego de mesa Wizard
 * @param args
 */
    public static void main(String[] args){    
      Sistema sistema = new Sistema();
      Juego juego = new Juego();
      Tablero tablero = new Tablero();
      sistema.iniciar(); 
      
    }
}
