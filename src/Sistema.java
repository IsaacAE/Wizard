/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import wizard.Archivo;
//import javax.lang.model.util.ElementScanner14;
//import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import wizard.src.Estructuras.*;

public class Sistema {

  Scanner escaner = new Scanner(System.in);
  Juego juego = new Juego();
  Tablero tablero = new Tablero();
  Archivo ob = new Archivo();

  // ob.Historial(juego, tablero);
  boolean valido = false;

  /**
 * Metodo que inicia el juego de Wizard y termina al acabar las rondas o cuando el usuario decida
 */
  public void iniciar() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("Bienvenido a wizard");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*- \n");
    escaner = new Scanner(System.in);
    int contador = 1;
    do {
      valido = true;
      int eleccion = 0;
      System.out.println("1.- agregar jugador  2.- comenzar juego 3.- salir");
      try {
        eleccion = escaner.nextInt();
      } catch (InputMismatchException et) {
        valido = false;
        System.out.println("ERROR 404");
        escaner.next();
        //escaner.next();
      }
      if (eleccion == 1) {
        if (contador <= 6) {
          solicitarDatos();
          contador++;
        } else {
          System.out.println("Ya se registro el numero maximo");
        }
        valido = false;
      } else if (eleccion == 2) {
        if (validarComienzo()) {
          System.out.println("Comenzando en breves");
          iniciarJuego();
          juego.modMaxRondas();
          int dec = 0;
          while (tablero.getRonda() <= juego.getMaxRondas()) {
            if (dec == 1) {
              break;
            }
            // tablero.getMazoGuia().setPalo("verde");
            //tablero.getBarajita().revolver();
            tablero.repartir(juego.getJugadores());
            System.out.println("RONDA: " + tablero.getRonda());
            detMazoTriunfo();
            //System.out.println("Mostando baraja "+tablero.getBarajita());
            juego.jugarRonda(tablero);
            //Recorrer con un iterador
            /*for(int i=1; i<=juego.getJugadores().size(); i++){
              System.out.println(juego.getJugadores().elemInd(i+1).getJugadas().toString());
            }*/

            System.out.println("\n¿Desea terminar el juego?\n1.SI\n2.NO");
            boolean bobo = false;

            do {
              bobo = false;
              try {
                dec = escaner.nextInt();
              } catch (InputMismatchException ed) {
                escaner.nextLine();
                System.out.println(
                  "Debe elegir entre la opcion 1 o 2 colocando el numero correspondiente"
                );
              }
              if (dec == 2) {
                System.out.println("Sigamos entonces");
                bobo = false;
              } else if (dec == 1) {
                break;
              } else {
                System.out.println("Eleccion no valida");
                bobo = true;
              }
            } while (bobo == true);
          }
          tablero.pasaRonda();
        }
      } else if (eleccion == 3) {
        break;
      }
      //System.out.println(valido);
    } while (valido == false);
  }

  /**
 * Metodo que solicita a los usuarios que apuesten segun la ronda
 * @param ronda Ronda del juego
 */
  public void apostar(int ronda) {
    juego.apuestas(ronda);
  }

  /**
   * va a mostrar a los jugadores registrados
   * llama el metodo barajear
   */
  private void iniciarJuego() {
    juego.mostrarJugadores();
    barajear();
    //System.out.println("Mostando la baraja "+juego.barajita);
    //break;
  }

  /**
 * Metodo que valida si se puede comenzar el juego o no
 */
  private boolean validarComienzo() {
    int jugadoresN = juego.getJugadores().size();
    if (jugadoresN >= 3 && jugadoresN <= 6) {
      return true;
    } else {
      System.out.println("\n Se necesitan minimo 3 jugadores y maximo 6");
      System.out.println("Jugadores actuales: " + jugadoresN + " \n");
      return false;
    }
  }

  /**
 * Metodo que solicita los datos a los usuarios
 */
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
    System.out.println("Jugadores registrados: " + juego.jugadores.size());
  }

  /**
   * Validar si el nombre del jugador ya existe, en caso
   * de que si, no se puede volver a repetir
   * @param nombre
   * @return boolean
   */
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

  /**
   * manda a llamar al metodo barajear jugador y la baraja que regresa la
   * guardamos en barajear
   */
  public void barajear() {
    tablero.setBarajita(juego.barajearJugador(tablero).getBarajita());
  }

  /**
   * Determina el mazo del triunfo, va a sacar una carta ya revuelta de la baraja,
   * si esta no es joker ni wizard se imprime, si es joker se juega sin palo del triunfo,
   * si es wizard manda a llamar el metodo defPaloTriundoWizard de la clase juego que
   * regresa un tablero
   *
   * @return Carta
   */
  public Carta detMazoTriunfo() {
    //Carta aux = tablero.sacarPaloTrinfo();
    Carta aux = tablero.barajita.sacarCarta();
    if (aux.getPalo().equals("blanco")) {
      System.out.println("Palo del triunfo" + aux);
      System.out.println("se juega sin palo del triunfo");
    } else if (aux.getPalo().equals("morado")) {
      System.out.println("Palo del triunfo" + aux);
      System.out.println("El palo lo elige quien barajeo");
      System.out.println(juego.barajeadores.peek());
      tablero = juego.defPaloTriunfoWizard(tablero);
      System.out.println(
        "palo del triunfo " +
        tablero.getMazoTriunfo() +
        " palo -> " +
        tablero.getMazoTriunfo().getPalo()
      );
    } else {
      System.out.println("Palo del triunfo" + aux);
      tablero.setMazoTriunfo(aux);
    }

    return aux;
   
  }

}
