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
   /* Lista <Integer> lista = new Lista<>();*/
    Baraja a = new Baraja("rojo");
    Baraja b = new Baraja("blanco");
    Baraja c = new Baraja("morado");
    Baraja d = new Baraja("azul");
    Baraja e = new Baraja("verde");
    Baraja f = new Baraja("amarillo");
    


  /* for(int i = 1; i<10; i++){
        lista.add(i);
    }*/
    System.out.println(a.toString());
    System.out.println(e.toString());
    System.out.println(f.toString());
    System.out.println(d.toString());
    System.out.println(b.toString());
    System.out.println(c.toString());
    
  //  a.cambiarCarta(0, 11);
  //  d.revolver();
    System.out.println(a.toString());
    System.out.println(d.toString());
    //System.out.println(lista);
    System.out.println(joker.toString());
    Jugador jg = new Jugador("Mauricio");
    Lista<Carta> lista = new Lista<>();
    lista.add(red);
    lista.add(yellow);
    lista.add(blue);
    lista.add(green);
    lista.add(magic);
    lista.add(joker);
    System.out.println("Esta es la lista"+lista);
    jg.mano = lista;
    System.out.println("Mostrando mano \n"+jg.mostrarMano());
    Baraja mazoP= new Baraja();
    
  System.out.println(mazoP.toString());
  mazoP.revolver();
  System.out.println(mazoP.toString());
  /*Carta aux = new Carta("neutro", "2");
  Carta[] ojo = mazoP.getMazoCartas();
    for(int k = 0; k<ojo.length; k++){
       aux = mazoP.sacarCarta();
        System.out.println(aux.toString());
    }*/

 // Carta[] aux = mazoP.getMazoCartas();
 //BORRABLE
 /*int j = 0;
 Carta[] hope = a.getMazoCartas();
  for( int i = 0; i<hope.length;i++){
        aux[j]= a.getMazoCartas()[i];
        j++;
  }
System.out.println(j);
  Carta[] pope= b.getMazoCartas();
  for( int i = 0; i<pope.length;i++){
        aux[j]= b.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);
  Carta[] rope = c.getMazoCartas();
  for( int i = 0; i<rope.length;i++){
        aux[j]= c.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);

  Carta[] lope = d.getMazoCartas();
  for( int i = 0; i<lope.length;i++){
        aux[j]= d.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);
  Carta[] tope = e.getMazoCartas();
  for( int i = 0; i<tope.length;i++){
        aux[j]= e.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);
  Carta[] yope = f.getMazoCartas();
  for( int i = 0; i<yope.length;i++){
        aux[j]= f.getMazoCartas()[i];
        j++;
  }
  System.out.println(j);

  System.out.println(j);
  for( int i = 0; i<aux.length;i++){
    System.out.print(aux[i].toString());
  }

*/
//FIN BORRABLE
   // System.out.println(red.toString());
    }

    
}
