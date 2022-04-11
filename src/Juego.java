/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;
 
import java.util.Iterator;
import wizard.src.Estructuras.*;
import wizard.src.Jugador;

public class Juego {

  Lista<Lista<Integer>> puntosJugadores = new Lista();
  Lista<Jugador> jugadores = new Lista();
  Baraja barajita;
 
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
    System.out.println(jugadores+"\n");
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
