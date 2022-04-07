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
  //Lista<Cola<Carta>> jugadas = new Lista();
  Lista<Integer> prediccion = new Lista();

  public Lista<Carta> getMano(){
    return this.mano;
  }

  public Jugador(String nombre) {
    this.nombre = nombre;
  }

  public String mostrarMano() {
    String string = "", stringAux=" ";
    int j =1;
    Iterator<Carta> iteradorLista = mano.iterator();
    while (iteradorLista.hasNext()) {
      string += " " + iteradorLista.next().toString() + " ";
      stringAux += " " + j + " ";
      j++;
    }
    string += "\n"+stringAux;
    return string;
  }

  public Baraja barajear(Baraja baraja) {
    baraja.revolver();
    return baraja;
  } 

  public String toString() {
    return this.nombre;
  }  

  public static Carta jugarCarta(Lista<Carta> mano, int indice){
    return mano.eliminarIndice(indice);
  }
}

