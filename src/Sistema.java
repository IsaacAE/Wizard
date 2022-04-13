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
      int eleccion = 0;
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
            juego.modMaxRondas();
while(tablero.getRonda()<=juego.getMaxRondas()){
           Baraja barajita = new Baraja();
           tablero.getBarajita().revolver();
           // tablero.getMazoGuia().setPalo("verde");
            //tablero.getBarajita().revolver();
            tablero.repartir(juego.getJugadores());
            System.out.println("RONDA: "+ tablero.getRonda());
            System.out.println("Barajea "+ juego.getJugadores().peek());
            detMazoTriunfo();
            
            juego.jugarRonda(tablero);
           tablero.setBarajita(barajita);
}
tablero.pasaRonda();
            
            
            
          }
        }else if (eleccion == 3) {
          break;
        }

     
      //System.out.println(valido);
    } while (valido == false);
  }

  public void apostar(int ronda) {
    juego.apuestas(ronda);
  }

  /**
   * va a mostrar a los jugadores registrados
   * llama el metodo barajear
   */
  private void iniciarJuego() {
    juego.mostrarJugadores();
    barajear();
    //System.out.println("Mostando la baraja "+juego.barajita);
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

  /**
   * Validar si el nombre del jugador ya existe, en caso
   * de que si, no se puede volver a repetir
   * @param nombre
   * @return boolean
   */
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

  /**
   * manda a llamar al metodo barajear jugador y la baraja que regresa la 
   * guardamos en barajear
   */
  public void barajear() {
    tablero.setBarajita(juego.barajearJugador(tablero).getBarajita());
  }

  /**
   * Determina el mazo del triunfo, va a sacar una carta ya revuelta de la baraja,
   * si esta no es joker ni wizard se imprime, si es joker se juega sin palo del triunfo,
   * si es wizard manda a llamar el metodo defPaloTriundoWizard de la clase juego que 
   * regresa un tablero
   * 
   * @return Carta
   */
  public Carta detMazoTriunfo() {
    //Carta aux = tablero.sacarPaloTrinfo();
    Carta aux = tablero.barajita.sacarCarta();
    if(aux.getPalo().equals("blanco")){
      System.out.println("Palo del triunfo" + aux);
      System.out.println("se juega sin palo del triunfo");
    }else if(aux.getPalo().equals("morado")){
      System.out.println("Palo del triunfo" + aux);
      System.out.println("El palo lo elige quien barajeo");
      System.out.println(juego.barajeadores.peek());
      tablero = juego.defPaloTriunfoWizard(tablero);
      System.out.println("palo del triunfo "+tablero.getMazoTriunfo()+" palo -> "+tablero.getMazoTriunfo().getPalo());
      
    }else{
      System.out.println("Palo del triunfo" + aux);
      tablero.setMazoTriunfo(aux);
    }
    
    return aux;
    //Carta ojo = new Carta ("blanco", "J");
    //tablero.setMazoTriunfo(ojo);

    /*tablero.setMazoTriunfo(tablero.getBarajita().cartaIndex(0));
    if (
      tablero.getMazoTriunfo().getPalo() == "blanco" ||
      tablero.getMazoTriunfo().getPalo() == "morado"
    ) {
      do {
        valido = true;
        int eleccionPalo = 0;
        Carta paloT = new Carta("rojo", "*");
        System.out.println(
          "Elige el palo del mazo guia, puedes elegir entre: \n1. rojo \n2. azul \n3. verde \n4. amarillo"
        );
        try {
          eleccionPalo = escaner.nextInt();
        } catch (InputMismatchException et) {
          valido = false;
          // System.out.println("ERROR 404");
          escaner.next();
          //escaner.next();
        }
        switch (eleccionPalo) {
          case 1:
>>>>>>> e34f795b70451f8f2c7e511a3125c8f3481bc4a2
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
<<<<<<< HEAD
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
=======
            break;
          default:
            valido = false;
            break;
        }
      } while (valido == false);
      //System.out.println("Funciona");
    }
    tablero.barajita.getMazoCartas()[0] = null;
    return tablero.getMazoTriunfo();*/

  }
  //Baraja barajaP = tablero.getBarajita();
  //Jugador jugadorP = juego.jugadores.peek();
  //Baraja barajaP = jugadorP.barajear(tablero.getBarajita());
  //barajaP.cartaInd(0);
  //tablero.setMazoTriunfo(barajaP.cartaInd(0));
  //tablero.setBarajita(juego.jugadores.peek.barajear(tablero.getBarajita()));

}
 