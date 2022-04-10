/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.Iterator;
import wizard.src.Estructuras.*;
import wizard.src.Jugador;

public class Tablero {

  Carta mazoTriunfo = new Carta("nulo", "o");
  Carta mazoGuia = new Carta("nulo", "o");
  Baraja barajita = new Baraja();
  int ronda = 1;

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

  public Carta sacarPaloTrinfo() {
    Carta aux = this.getBarajita().cartaIndex(0);
    this.setMazoTriunfo(aux);
    return aux;
  }

  public void ganador() {}

  public Carta getMazoTriunfo() {
    return this.mazoTriunfo;
  }

  public Carta getMazoGuia() {
    return this.mazoGuia;
  }

  public int getRonda() {
    return this.ronda;
  }

  public void setMazoGuia(int ronda) {
    this.ronda = ronda;
  }

  public Baraja getBarajita() {
    return this.barajita;
  }

  public void setMazoTriunfo(Carta mazoTriunfo) {
    this.mazoTriunfo = mazoTriunfo;
  }

  public void setMazoGuia(Carta mazoGuia) {
    this.mazoGuia = mazoGuia;
  }

  public void setBarajita(Baraja barajita) {
    this.barajita = barajita;
  }
}
