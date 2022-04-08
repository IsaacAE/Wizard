/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;
 
import java.util.InputMismatchException;
import java.util.Scanner;
//import javax.lang.model.util.ElementScanner14;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import wizard.src.Estructuras.*;

public class Sistema {

  Scanner escaner = new Scanner(System.in);
  Juego juego = new Juego();
  Tablero tablero = new Tablero();
  boolean valido = false;

  public void iniciar() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("Bienvenido a wizard");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*- \n");
    escaner = new Scanner(System.in);
    do {
      valido = true;
      int eleccion=0;
      System.out.println("1.- agregar jugador  2.- comenzar juego 3.- salir");
      try {
        eleccion = escaner.nextInt();
         } catch (InputMismatchException et) {
        valido = false;
        System.out.println("ERROR 404");
        escaner.next();
        //escaner.next();
      }
        if (eleccion == 1) {
          solicitarDatos();
          valido = false;
        } else if (eleccion == 2) {
          if (validarComienzo()) {
            System.out.println("Comenzando en breves");
            
            iniciarJuego();
            detMazoTriunfo();
            System.out.print("\n El palo de triunfo es: " + tablero.getMazoTriunfo().toString());
            valido = true;
            System.out.println(valido);
           // break; //*************
          } //else {
            //valido = false;
         // }
        }else if (eleccion == 3) {
          break;
        } else {
          valido=false;
        }
     
      System.out.println(valido);
    } while (valido == false);
  }

  private void iniciarJuego() {
    juego.mostrarJugadores();
    //break;
  }

  private boolean validarComienzo() {
    int jugadoresN = juego.getJugadores().size();
    if (jugadoresN >= 3 && jugadoresN <= 6) {
      return true;
    } else {
      System.out.println("\n Se necesitan minimo 3 jugadores y maximo 6");
      System.out.println("Jugadores actuales: " + jugadoresN + " \n");
      return false;
    }
  }

  private void solicitarDatos() {
    escaner = new Scanner(System.in);
    valido = false;
    String nombre = "";
    do {
      valido = true;
      System.out.println("Escribe tu nombre");
      try {
        nombre = escaner.nextLine();
        if (!validarNombre(nombre)) {
          System.out.println("Ese nombre ya esta registrado");
          throw new InputMismatchException();
        }
      } catch (InputMismatchException et) {
        valido = false;
        //escaner.next();
      }
    } while (valido == false);
    juego.jugadores.add(new Jugador(nombre));
    System.out.println("Jugador agregado exitosamente");
  }

  private boolean validarNombre(String nombre) {
    //boolean bol = true;
    Jugador aux = juego.buscarJugador(nombre);
    if (juego.getJugadores().size() <= 0) {
      return true;
    }
    if (aux != null) {
      if (aux.getNombre().equals(nombre)) {
        return false;
      }
    }

    return true;
  }

  public Carta detMazoTriunfo(){
    //Carta ojo = new Carta ("blanco", "J");
    //tablero.setMazoTriunfo(ojo);
    tablero.setBarajita(juego.jugadores.peek().barajear(tablero.getBarajita()));
      tablero.setMazoTriunfo(tablero.getBarajita().cartaInd(0));
      if(tablero.getMazoTriunfo().getPalo()== "blanco" || tablero.getMazoTriunfo().getPalo()== "morado"){
        
        do {
          valido = true;
          int eleccionPalo=0;
          Carta paloT = new Carta("rojo", "*");
          System.out.println("Elige el palo del mazo guia, puedes elegir entre: \n1. rojo \n2. azul \n3. verde \n4. amarillo");
          try {
            eleccionPalo = escaner.nextInt();
             } catch (InputMismatchException et) {
            valido = false;
           // System.out.println("ERROR 404");
            escaner.next();
            //escaner.next();
          }
          switch(eleccionPalo){
            case 1: 
            
            tablero.setMazoTriunfo(paloT);
            break;

            case 2: 
            paloT.setPalo("azul");
            paloT.setValor("||");
            tablero.setMazoTriunfo(paloT);
            break;

            case 3: 
            paloT.setPalo("verde");
            paloT.setValor("<>");
            tablero.setMazoTriunfo(paloT);
            break;

            case 4: 
            paloT.setPalo("amarillo");
            paloT.setValor("#");
            tablero.setMazoTriunfo(paloT);
            break;

            default:

            valido=false;
            break;

          }
        }while(valido==false);

        //System.out.println("Funciona");
      }
tablero.barajita.getMazoCartas()[0]=null;
      return tablero.getMazoTriunfo();
  }
  
  //Baraja barajaP = tablero.getBarajita();
  //Jugador jugadorP = juego.jugadores.peek();
  //Baraja barajaP = jugadorP.barajear(tablero.getBarajita());
  //barajaP.cartaInd(0);
    //tablero.setMazoTriunfo(barajaP.cartaInd(0));
   //tablero.setBarajita(juego.jugadores.peek.barajear(tablero.getBarajita()));

}
