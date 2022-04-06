/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import wizard.src.Estructuras.*;

public class Tablero{
     Carta mazoTriunfo;
     Carta mazoGuia;

     public Lista<Carta> repartir(int ronda, Baraja baraja){
        Lista <Carta> reparticion = new Lista();
        for(int i = 0; i<ronda; i++){
            reparticion.add(baraja.sacarCarta());
        }
        return reparticion;
     }

     public void ganador(){

     }
}