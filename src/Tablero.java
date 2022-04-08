/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.Iterator;
import wizard.src.Estructuras.*;
import wizard.src.Jugador;

public class Tablero {

  Carta mazoTriunfo;
  Carta mazoGuia;
  Baraja barajita = new Baraja();

  /**
   * Reparte cartas a cada jugador contenido en la lista jugadores
   * según el numero de ronda, regresa una lista de jugadores en
   * donde la mano de este ya esta actualizada
   * @param ronda
   * @param jugadores
   * @return
   */
  public Lista<Jugador> repartir(int ronda, Lista<Jugador> jugadores) {
    Lista<Carta> reparticion = new Lista();
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    for (int i = 0; i < jugadores.size(); i++) {
      for (int j = 0; j < ronda; j++) {
        reparticion.add(barajita.sacarCarta());
      }
      if (iteradorLista.hasNext()) {
        iteradorLista.next().setMano(reparticion);
        reparticion = new Lista();
      }
    }

    return jugadores;
  }

  public void ganador() {}
}
