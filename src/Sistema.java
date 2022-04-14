/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import javax.lang.model.util.ElementScanner14;
//import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import wizard.src.Estructuras.*;
import wizard.Archivo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Sistema {

  Scanner escaner = new Scanner(System.in);
  Juego juego = new Juego();
  Tablero tablero = new Tablero();
  Archivo ob = new Archivo();
 
     // ob.Historial(juego, tablero);
  boolean valido = false;

  public void iniciar() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    System.out.println("Bienvenido a wizard");
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*- \n");
    escaner = new Scanner(System.in);
    int contador = 1;
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
        if(contador <= 6){
          solicitarDatos();
          contador++;
        }else{
          System.out.println("Ya se registro el numero maximo");
        }
        valido = false;
      } else if (eleccion == 2) {
        if (validarComienzo()) {
          System.out.println("Comenzando en breves");
          iniciarJuego();
          juego.modMaxRondas();
          int dec=0;
          while (tablero.getRonda() <= juego.getMaxRondas()) {
            
            if(dec==1){
              break;
            }
            // tablero.getMazoGuia().setPalo("verde");
            //tablero.getBarajita().revolver();
            tablero.repartir(juego.getJugadores());
            System.out.println("RONDA: " + tablero.getRonda());
            detMazoTriunfo();
            System.out.println("Mostando baraja "+tablero.getBarajita());
            juego.jugarRonda(tablero);
            for(int i=1; i<=juego.getJugadores().size(); i++){
              System.out.println(juego.getJugadores().elemInd(i).getJugadas().toString());
            }
          
      System.out.println("\n¿Desea terminar el juego?\n1.SI\n2.NO");
      boolean bobo= false;
    
      do{
        bobo=false;
      try{
        ;
       dec = escaner.nextInt();
      }catch(InputMismatchException ed){
        escaner.nextLine();
        System.out.println("Debe elegir entre la opcion 1 o 2 colocando el numero correspondiente");

      }
      if(dec == 2){
        System.out.println("Sigamos entonces");
        bobo=false;
      }else if(dec==1){
     ob.Historial(this.juego, this.tablero);
     /*try{
     FileOutputStream os = new FileOutputStream("historial.txt");
PrintStream ps = new PrintStream(os);
//ps.println("prueba de impresión realizada");
     }catch(FileNotFoundException efe){
       System.out.println("ALGO SALIO MAL");
     }*/
      break;
      
      
      }else{
        System.out.println("Eleccion no valida");
        bobo=true;
      }
    }while(bobo==true);
          }
          tablero.pasaRonda();
        }
      } else if (eleccion == 3) {
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
    System.out.println("Jugadores registrados: "+juego.jugadores.size());
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
    if (aux.getPalo().equals("blanco")) {
      System.out.println("Palo del triunfo" + aux);
      System.out.println("se juega sin palo del triunfo");
    } else if (aux.getPalo().equals("morado")) {
      System.out.println("Palo del triunfo" + aux);
      System.out.println("El palo lo elige quien barajeo");
      System.out.println(juego.barajeadores.peek());
      tablero = juego.defPaloTriunfoWizard(tablero);
      System.out.println(
        "palo del triunfo " +
        tablero.getMazoTriunfo() +
        " palo -> " +
        tablero.getMazoTriunfo().getPalo()
      );
    } else {
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
