/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import wizard.src.Estructuras.*;
//import Estructuras.*;
import java.util.Iterator;

public class Jugador {

  Lista<Carta> mano = new Lista();
  String nombre;
  Lista<Cola<Carta>> jugadas = new Lista();
  Lista<Integer> prediccion = new Lista();

  public Jugador(String nombre) {
    this.nombre = nombre;
  }

  public String mostrarMano(){
      String string = "";
      Iterator <Carta> iteradorLista = mano.iterator();
      while(iteradorLista.hasNext()){
        string += " " + iteradorLista.next().toString() + " ";
      }
      return string;
  }
}
