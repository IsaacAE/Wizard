/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import wizard.src.Estructuras.*;

public class Sistema {

  Scanner escaner = new Scanner(System.in);
  Juego juego = new Juego();
  boolean valido = false;

  public void iniciar() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("Bienvenido a wizard");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*- \n");
    escaner = new Scanner(System.in);
    do {
      valido = true;
      int eleccion;
      System.out.println("1.- agregar jugador  2.- comenzar juego 3.- salir");
      try {
        eleccion = escaner.nextInt();
        if (eleccion == 1) {
          solicitarDatos();
          valido = false;
        } else if (eleccion == 2) {
          if (validarComienzo()) {
            System.out.println("Comenzando en breves");
            valido = true;
            iniciarJuego();
          } else {
            valido = false;
          }
        }
        if (eleccion == 3) {
          break;
        } else {
          throw new InputMismatchException();
        }
      } catch (InputMismatchException et) {
        valido = false;
        //escaner.next();
      }
      System.out.println(valido);
    } while (valido == false);
  }

  private void iniciarJuego() {
    juego.mostrarJugadores();
  }

  private boolean validarComienzo() {
    int jugadoresN = juego.getJugadores().size();
    if (jugadoresN >= 3 && jugadoresN <= 5) {
      return true;
    } else {
      System.out.println("\n Se necesitan minimo 3 jugadores y maximo 5");
      System.out.println("Jugadores actuales: " + jugadoresN + " \n");
      return false;
    }
  }

  private void solicitarDatos() {
    escaner = new Scanner(System.in);
    valido = false;
    String nombre = "";
    do {
      valido = true;
      System.out.println("Escribe tu nombre");
      try {
        nombre = escaner.nextLine();
        if (!validarNombre(nombre)) {
          System.out.println("Ese nombre ya esta registrado");
          throw new InputMismatchException();
        }
      } catch (InputMismatchException et) {
        valido = false;
        //escaner.next();
      }
    } while (valido == false);
    juego.jugadores.add(new Jugador(nombre));
    System.out.println("Jugador agregado exitosamente");
  }

  private boolean validarNombre(String nombre) {
    //boolean bol = true;
    Jugador aux = juego.buscarJugador(nombre);
    if (juego.getJugadores().size() <= 0) {
      return true;
    }
    if (aux != null) {
      if (aux.getNombre().equals(nombre)) {
        return false;
      }
    }

    return true;
  }
}
