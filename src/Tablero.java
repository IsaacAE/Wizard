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
  public Lista<Jugador> repartir(Lista<Jugador> jugadores) {
    Lista<Carta> reparticion = new Lista();
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    for (int i = 0; i < jugadores.size(); i++) {
      for (int j = 0; j < this.ronda; j++) {
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
    Carta aux = this.getBarajita().sacarCarta();
    this.setMazoTriunfo(aux);
    return aux;
  }

  

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

  public void pasaRonda(){
    this.ronda += 1;
  }
/**
   * Metodo para saber si hay un palo guia valido
   * @return boolean
   */
  public boolean hayMazoGuia(){
    if(mazoGuia.getPalo()=="verde" || mazoGuia.getPalo()=="rojo" || mazoGuia.getPalo()=="azul" || mazoGuia.getPalo()=="amarillo"){
      return true;
    }
    else{
      return false;
    }
  }
}
