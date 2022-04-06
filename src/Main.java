/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;
import wizard.src.Estructuras.*;
public class Main{

    public static void main(String[] args){

	Carta red = new Carta("rojo", "3");
    Carta yellow = new Carta("amarillo", "13");
    Carta blue= new Carta("azul", "1");
    Carta green = new Carta("verde", "9");
    Carta magic = new Carta("morado", "W");
    Carta joker = new Carta("blanco", "J");
    System.out.println(red.toString());
    System.out.println(blue.toString());
    System.out.println(green.toString());
    System.out.println(yellow.toString());
    System.out.println(magic.toString());
    System.out.println(joker.toString());
    Lista <Integer> lista = new Lista<>();
    Baraja a = new Baraja("rojo");
    Baraja b = new Baraja("blanco");
    Baraja c = new Baraja("morado");
    Baraja d = new Baraja("azul");
    


  /*  for(int i = 1; i<10; i++){
        lista.add(i);
    }*/
    System.out.println(a.toString());
    System.out.println(b.toString());
    System.out.println(c.toString());
    System.out.println(d.toString());
    a.cambiarCarta(0, 11);
    d.barajear();
    System.out.println(a.toString());
    System.out.println(d.toString());
    //System.out.println(lista);
   // System.out.println(red.toString());
    }

    
}
