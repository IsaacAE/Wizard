/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

//import Estructuras.*;
import java.util.Iterator;
import wizard.src.Estructuras.*;

public class Jugador {

  Lista<Carta> mano = new Lista();
  String nombre;
  Lista<Integer> prediccion = new Lista();

  //Lista<Cola<Carta>> jugadas = new Lista();

  /**
   * Constructor
   * @param nombre
   */
  public Jugador(String nombre) {
    this.nombre = nombre;
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
  public Baraja barajear(Baraja baraja) {
    baraja.revolver();
    return baraja;
  }
 
  /**
   * El jugador toma una carta de su mano y la regresa
   * @param indice
   * @return Carta
   */
  public Carta jugarCarta(int indice) {
    Carta aux = mano.elemInd(indice);
    return aux;
  }

  @Override
  public String toString() {
    //System.out.println(this.mostrarMano());
    return this.nombre;
  }

  public Lista<Carta> getMano() {
    return this.mano;
  }

  public void setMano(Lista<Carta> mano) {
    this.mano = mano;
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
