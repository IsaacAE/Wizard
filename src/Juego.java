/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import wizard.src.Estructuras.*;

public class Juego {

  Lista<Lista<Integer>> puntosJugadores = new Lista();

  public Juego(int jugadores) {
    Lista <Integer> jugador;
    for (int i = 0; i < jugadores; i++) {
        jugador = new Lista();
        puntosJugadores.add(jugador);
    }
  }
}
