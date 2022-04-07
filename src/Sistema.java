/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.InputMismatchException;
import java.util.Scanner;
import wizard.src.Estructuras.*;

public class Sistema {

  Juego juego = new Juego();

  public void iniciar() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("Bienvenido a wizard");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*- \n");
    juego.agregarJugadores(solicitarDatos());
  }

  public void login() throws Exception {
    System.out.println();
  }

  private Jugador solicitarDatos() {
    Scanner escaner = new Scanner(System.in);
    boolean valido = false;
    String nombre = "";
    do {
      valido = true;
      System.out.println("Escribe tu nombre");
      try {
        nombre = escaner.nextLine();
        if(! validarNombre(nombre)){
            System.out.println("Ese nombre ya esta registrado");
            throw new InputMismatchException();
        }
      } catch (InputMismatchException et) {
        valido = false;
        escaner.next();
      }
    } while (valido == false);
    Jugador jugadorNuevo = new Jugador(nombre);
    return jugadorNuevo;
  }

  private boolean validarNombre(String nombre) {
    //boolean bol = true;
    Jugador aux = juego.buscarJugador(nombre);
    if(juego.getJugadores().size() <= 0){
        return true;
    }
    if (aux.getNombre().equals(nombre)) {
      return false;
    }
    return false;
  }
}
