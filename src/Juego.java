/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import wizard.src.Estructuras.*;
import wizard.src.Jugador;
import wizard.src.Tablero;

public class Juego {

  Lista<Lista<Integer>> puntosJugadores = new Lista();
  Lista<Jugador> jugadores = new Lista();
  Baraja barajita;
  Cola<Jugador> barajeadores = new Cola();

  //private IteradorLista<Jugador> iteradorListaDosDirecciones = jugadores.iteradorLista();


  /* public Juego(int jugadores) {
    Lista <Integer> jugador;
    for (int i = 0; i < jugadores; i++) {
        jugador = new Lista();
        puntosJugadores.add(jugador);
    }
  }*/

  /**
   * Muestra a los jugadores contenidos en la lista e imprime
   * su mano
   */
  public void mostrarJugadoresM() {
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    Jugador aux;
    while (iteradorLista.hasNext()) {
      aux = iteradorLista.next();
      System.out.println(aux.nombre);
      System.out.println(aux.mostrarMano());
      System.out.println("-------------------");
    }
  }

  /**
   * Muestra a los jugadores contenidos en la lista
   */
  public void mostrarJugadores() {
    System.out.println("Estos son los jugadores");
    System.out.println(jugadores + "\n");
  }

  /**
   * Agregar jugadores a la lista
   * @param jugador
   */
  public void agregarJugadores(Jugador jugador) {
    jugadores.add(jugador);
  }

  /**
   * Busca a un jugador
   * @param nombre
   * @return
   */
  public Jugador buscarJugador(String nombre) {
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    Jugador aux;
    while (iteradorLista.hasNext()) {
      aux = iteradorLista.next();
      if (aux.nombre.equals(nombre)) {
        return aux;
      }
    }
    return null;
    //return jugadores.indexOf(nombre);
  }

  /**
   * Metodo para elegir que palo sera el del triunfo, el jugador puede elegir entre todos los colores
   * Falta evaluar este metodo segun el jugador
   * @param tablero
   * @return Tablero
   */
  public Tablero defPaloTriunfoWizard(Tablero tablero) {
    Scanner escaner = new Scanner(System.in);
    boolean valido;
    do {
      valido = true;
      int eleccionPalo = 0;
      Carta paloT = new Carta("rojo", "*");
      System.out.println(
        "Elige el palo del mazo guia, puedes elegir entre: \n1. rojo \n2. azul \n3. verde \n4. amarillo"
      );
      try {
        eleccionPalo = escaner.nextInt();
      } catch (InputMismatchException et) {
        valido = false;
        // System.out.println("ERROR 404");
        escaner.next();
        //escaner.next();
      }
      switch (eleccionPalo) {
        case 1:
          tablero.setMazoTriunfo(paloT);
          break;
        case 2:
          paloT.setPalo("azul");
          paloT.setValor("||");
          tablero.setMazoTriunfo(paloT);
          break;
        case 3:
          paloT.setPalo("verde");
          paloT.setValor("<>");
          tablero.setMazoTriunfo(paloT);
          break;
        case 4:
          paloT.setPalo("amarillo");
          paloT.setValor("#");
          tablero.setMazoTriunfo(paloT);
          break;
        default:
          valido = false;
          break;
      }
    } while (valido == false);
    //System.out.println("Funciona");
    tablero.barajita.getMazoCartas()[0] = null;
    return tablero;
  }

  /**
   * Barajear segun el jugador y segun la ronda
   * Solo esta programado que el primer jugador en registrarse sea quien barajea en
   * la primer ronda
   * @param tablero
   * @return Tablero
   */
  public Tablero barajearJugador(Tablero tablero) {
    int ronda = tablero.getRonda();
    if (ronda == 1) {
      tablero.setBarajita(jugadores.peek().barajear(tablero));
      this.setBarajita(tablero.getBarajita());
      barajeadores.push(jugadores.peek());
      System.out.println("Jugador: " + jugadores.peek() + " esta barajeando");
      return tablero;
    }
    this.setBarajita(tablero.getBarajita());
    return null;
  }

  public void setBarajita(Baraja barajita) {
    this.barajita = barajita;
  }

  public Baraja getBarajota() {
    return this.barajita;
  }

  public void setJugadores(Lista<Jugador> jugadores) {
    this.jugadores = jugadores;
  }

  public Lista<Jugador> getJugadores() {
    return this.jugadores;
  }

  public boolean validarJugada(Carta carta, Lista<Carta> cartas, Tablero tablero){
    boolean contiene=true;
    if(carta.getPalo()== "morado" ||carta.getPalo()== "blanco"){
      return true;
    }
      for(int i =0; i<cartas.longi; i++){
        if(cartas.elemInd(i).getPalo() == tablero.getMazoGuia().getPalo()){
          contiene = true;
          break;
        }else{
          contiene = false;
        }
      }
        if((contiene==true) && (carta.getPalo()!= tablero.getMazoGuia().getPalo())){
          return false;
        }else{
          return true;
        }
      
  }


  
}
