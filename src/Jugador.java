/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.lang.Math;
//import Estructuras.*;
import java.util.Iterator;
import wizard.src.Estructuras.*;

public class Jugador {

  Lista<Carta> mano = new Lista();
  String nombre;
  Lista<Integer> prediccion = new Lista();
  Lista<Integer> barajeo = new Lista();
  Lista<Carta> jugadas = new Lista();
  Lista<Integer> RondaPuntos = new Lista();
  Lista<Integer> puntos = new Lista();
  Lista<Integer> ronda = new Lista();
  int contadorTruco = 0;
  int puntosTotal = 0;

  public int getPuntosTotal(){
    return this.puntosTotal;
  }

  //Lista<Cola<Carta>> jugadas = new Lista();

  /**
   * Constructor
   * @param nombre
   */
  public Jugador(String nombre) {
    this.nombre = nombre;
  }

  public void ganoTruco() {
    contadorTruco += 1;
  }

  public int getContadorTruco() {
    return this.contadorTruco;
  }

  public void setContadorTruco(int contadorTruco) {
    this.contadorTruco = contadorTruco;
  }

  public Lista <Carta> getJugadas(){
    return this.jugadas;
  }

  public void trucosRonda() {
    RondaPuntos.add(contadorTruco);
  }

  public void puntosJugador() {
    //Iterator<Integer> iteradorPre = prediccion.iterator();
    //Iterator<Integer> iteradorPun = RondaPuntos.iterator();
    Integer aux1 = prediccion.peekInverse();
    Integer aux2 = RondaPuntos.peekInverse();
    Integer aux3 = 0;
    if (aux1 == aux2) {
      aux3 = (20 + (10 * aux1));
      puntosTotal += aux3;
      puntos.add(aux3);
    } else {
      aux3 = -10 * Math.abs(aux1 - aux2);
      puntosTotal += aux3;
      puntos.add(aux3);
    }
    mostrarPuntos();
  }

  public void mostrarPuntos() {
    /*Iterator<Integer> iteradorLista = puntos.iterator();
    while (iteradorLista.hasNext()) {
      System.out.println(
        "Jugador " + this.getNombre() + " puntos: " + iteradorLista.next()
      );
    }*/
    System.out.println(this.getNombre()+" tiene un total de " + puntosTotal);
  }
 
  /**
   * Se agrega un numero a la lista de predicciones
   * @param ganare
   */
  public void predecir(int ganare) {
    prediccion.add(ganare);
  }

  /**
   * Se muestra la prediccion segun la ronda
   * @param ronda
   * @return String
   */
  public String mostrarPrediccion(int ronda) {
    String aux = "";
    Iterator<Integer> iteradorLista = prediccion.iterator();
    if (ronda > prediccion.size()) {
      return "Aun no hay prediccion";
    }
    for (int i = 0; i < ronda; i++) {
      if (iteradorLista.hasNext()) {
        aux = String.valueOf(iteradorLista.next());
      }
    }
    return aux;
  }

  /**
   * Se muestra la prediccion segun la ronda
   * @param ronda
   * @return String
   */
  public String mostrarPrediccion() {
    String aux = "";
    Iterator<Integer> iteradorLista = prediccion.iterator();
    aux += prediccion.toString();
    return aux;
  }

  /**
   * Se muestra la mano actual del jugador
   * @return String
   */
  public String mostrarMano() {
    String string = "";
    Iterator<Carta> iteradorLista = mano.iterator();
    while (iteradorLista.hasNext()) {
      string += " " + iteradorLista.next().toString() + " ";
    }
    return string;
  }

  /**
   * El jugador recibe una baraja, la revuelve y la regresa
   * @param baraja
   * @return Baraja
   */
  public Baraja barajear(Tablero tablero) {
    Baraja baraja = tablero.getBarajita();
    //baraja.revolver();
    baraja.revolver();
    barajeo.add(tablero.getRonda());
    return baraja;
  }

  /**
   * El jugador toma una carta de su mano y la regresa
   * @param indice
   * @return Carta
   */
  public Carta jugarCarta(int indice) {
    Carta aux = mano.elemInd(indice);
   // jugadas.add(aux);
    return aux;
  }

  @Override
  public String toString() {
    //System.out.println(this.mostrarMano());
    return this.nombre;
  }

  public Lista<Integer> getRondaPuntos() {
    return this.RondaPuntos;
  }

  public void setRondaPuntos(Lista<Integer> rondasGanadas) {
    this.RondaPuntos = RondaPuntos;
  }

  public Lista<Carta> getMano() {
    return this.mano;
  }

  public void setMano(Lista<Carta> mano) {
    this.mano = mano;
  }

  public Lista<Integer> getBarajeo() {
    return this.barajeo;
  }

  public void setBarajeo(Lista<Integer> barajeo) {
    this.barajeo = barajeo;
  }

  public Lista<Integer> getPrediccion() {
    return this.prediccion;
  }

  public void setPrediccion(Lista<Integer> prediccion) {
    this.prediccion = prediccion;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
