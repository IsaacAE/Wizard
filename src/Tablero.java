/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.Iterator;

import wizard.src.Jugador;
import wizard.src.Estructuras.*;

public class Tablero{
     Carta mazoTriunfo;
     Carta mazoGuia;
     Baraja barajita = new Baraja();

     public Lista<Jugador> repartir(int ronda, Lista<Jugador> jugadores){
        Lista <Carta> reparticion = new Lista();
        Iterator<Jugador> iteradorLista = jugadores.iterator();
        for(int i = 0; i<jugadores.size(); i++){
            for(int j = 0; j<ronda; j++){
                reparticion.add(barajita.sacarCarta());
            }
            if(iteradorLista.hasNext()){
                 iteradorLista.next().setMano(reparticion);
                 reparticion = new Lista();
            }
        }

        return jugadores;
     }

     public void ganador(){

     }
}