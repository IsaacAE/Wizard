/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;
import wizard.src.Baraja;
import wizard.src.Estructuras.*;
public class Main{

    public static void main(String[] args){

	Carta red = new Carta("rojo", "3");
    Carta yellow = new Carta("amarillo", "13");
    Carta blue= new Carta("azul", "1");
    Carta green = new Carta("verde", "9");
    Carta magic = new Carta("morado", "W");
    Carta joker = new Carta("blanco", "J");
    /*System.out.println(red.toString());
    System.out.println(blue.toString());
    System.out.println(green.toString());
    System.out.println(yellow.toString());
    System.out.println(magic.toString());
    System.out.println(joker.toString());*/
    Jugador jg = new Jugador("Mauricio");
    Lista<Carta> lista = new Lista<>();
    lista.add(red);
    lista.add(yellow);
    lista.add(blue);
    lista.add(green);
    lista.add(magic);
    lista.add(joker);
    //System.out.println("Esta es la lista"+lista);
    jg.mano = lista;
    //System.out.println("Mostrando mano \n"+jg.mostrarMano());
    Baraja barajita = new Baraja();
    System.out.println("Esta es la baraja "+barajita);

   // System.out.println(red.toString());
    }

    
}
