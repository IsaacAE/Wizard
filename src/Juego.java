/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import wizard.src.Estructuras.*;
import wizard.src.Jugador;
import wizard.src.Tablero;

public class Juego {

  //Lista<Lista<Integer>> puntosJugadores = new Lista();
  Lista<Jugador> jugadores = new Lista();
  Baraja barajita;
  Cola<Jugador> barajeadores = new Cola();
  int maxRondas = 0;
  Jugador ganadorAct;
  Scanner escaner;

  //private IteradorLista<Jugador> iteradorListaDosDirecciones = jugadores.iteradorLista();

  /* public Juego(int jugadores) {
    Lista <Integer> jugador;
    for (int i = 0; i < jugadores; i++) {
        jugador = new Lista();
        puntosJugadores.add(jugador);
    }
  }*/
  public void modMaxRondas() {
    int aux = jugadores.size();
    switch (aux) {
      case 3:
        maxRondas = 20;
        break;
      case 4:
        maxRondas = 15;
        break;
      case 5:
        maxRondas = 12;
        break;
      case 6:
        maxRondas = 10;
        break;
    }
  }

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
    System.out.println(jugadores + "\n");
  }

  public int getMaxRondas() {
    return this.maxRondas;
  }

  public void mostrarPredicciones() {
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    Jugador aux;
    while (iteradorLista.hasNext()) {
      aux = iteradorLista.next();
      System.out.println("Prediccion del jugador " + aux.getNombre());
      System.out.println(aux.mostrarPrediccion());
    }
  }

  public void mostrarTrucosGanados() {
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    Jugador aux;
    while (iteradorLista.hasNext()) {
      aux = iteradorLista.next();
      System.out.println(
        "El jugador  " + aux.getNombre() + " gano " + aux.getContadorTruco()
      );
    }
  }

  public void vaciarTrucosGanados() {
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    Jugador aux;
    while (iteradorLista.hasNext()) {
      aux = iteradorLista.next();
      aux.setContadorTruco(0);
    }
  }

  //Falta determina quien va a ganar una ronda

  public void apuestas(int ronda) {
    escaner = new Scanner(System.in);
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    Jugador aux;
    int apuesta;
    boolean bol = false;
    for (int i = 0; i < jugadores.size(); i++) {
      aux = iteradorLista.next();
      System.out.println(aux.getNombre() + " tu mano es: " + aux.mostrarMano());
      System.out.println("Jugador " + aux.getNombre() + " debe apostar");
      do {
        System.out.println("¿Cuantas rondas ganaras? (0 - " + (ronda) + ")");
        try {
          apuesta = escaner.nextInt();
          if (!(apuesta >= 0 && apuesta <= ronda)) {
            bol = false;
            System.out.println("Ingresa una opcion valida");
          } else {
            bol = true;
            aux.predecir(apuesta);
          }
        } catch (Exception e) {
          System.out.println("ERROR");
          bol = false;
          escaner = new Scanner(System.in);
        }
      } while (!bol);
    }
    mostrarPredicciones();
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

  /**
   * Metodo para elegir que palo sera el del triunfo, el jugador puede elegir entre todos los colores
   * Falta evaluar este metodo segun el jugador
   * @param tablero
   * @return Tablero
   */
  public Tablero defPaloTriunfoWizard(Tablero tablero) {
    Scanner escaner = new Scanner(System.in);
    boolean valido;
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
          valido = false;
          break;
      }
    } while (valido == false);
    //System.out.println("Funciona");
    tablero.barajita.getMazoCartas()[0] = null;
    return tablero;
  }

  /**
   * Barajear segun el jugador y segun la ronda
   * Solo esta programado que el primer jugador en registrarse sea quien barajea en
   * la primer ronda
   * @param tablero
   * @return Tablero
   */
  public Tablero barajearJugador(Tablero tablero) {
    int ronda = tablero.getRonda();
    System.out.println("ronda -->" + ronda);
    if (ronda == 1 || ronda != 0) {
      tablero.setBarajita(jugadores.peek().barajear(tablero));
      this.setBarajita(tablero.getBarajita());
      barajeadores.push(jugadores.peek());
      System.out.println("Jugador: " + jugadores.peek() + " esta barajeando");
      return tablero;
    }
    this.setBarajita(tablero.getBarajita());
    return null;
  }

  public void setBarajita(Baraja barajita) {
    this.barajita = barajita;
  }

  public Baraja getBarajota() {
    return this.barajita;
  }

  public void setJugadores(Lista<Jugador> jugadores) {
    this.jugadores = jugadores;
  }

  public Lista<Jugador> getJugadores() {
    return this.jugadores;
  }

  /**
   * Metodo para verificar que la jugada que quiere realizar el jugador es valida
   * @param carta Representa la carta que quiere jugarse
   * @param cartas Representara las cartas en la mano del jugador
   * @param tablero Representa el tablero en donde se juega la partida
   * @return boolean
   */
  public boolean validarJugada(
    Carta carta,
    Lista<Carta> cartas,
    Tablero tablero
  ) {
    boolean contiene = true;

    if (carta.getPalo() == "morado" || carta.getPalo() == "blanco") {
      return true;
    }
    for (int i = 0; i <= cartas.longi; i++) {
      if (cartas.elemInd(i).getPalo() == tablero.getMazoGuia().getPalo()) {
        contiene = true;
        break;
      } else {
        contiene = false;
      }
    }
    if (
      (contiene == true) && (carta.getPalo() != tablero.getMazoGuia().getPalo())
    ) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Metodo para jugar toda una ronda hasta que el ultimo jugador se quede sin cartas
   * @param tablero Representa el tablero en donde se juega la partida
   */
  public void jugarRonda(Tablero tablero) {
    //Carta mago = new Carta("morado", "W");
    int i = 0, j = 0;
    boolean continua = true;
    int numJug = jugadores.longi - 1;
    modMaxRondas();
    int rondasJug = tablero.getRonda();
    //while(rondasJug<=maxRondas){

    apuestas(tablero.getRonda());
    while (jugadores.elemInd(numJug).getMano().isEmpty() == false) {
      // System.out.println(jugarTurno(tablero).toString());
      Lista<Carta> cartasJugadas = jugarTurno(tablero);

      System.out.println(
        "Las cartas jugadas fueron: " + cartasJugadas.toString()
      );

      //System.out.println("Mandando a llamar ganar truco");
      Jugador ganadorT = ganador(cartasJugadas, tablero);
      System.out.println("El ganador del truco es: " + ganadorT.toString());
      //ganadorTruco(ganadorT);
      ganadorTruco(buscarJugador(ganadorT.getNombre()));
      tablero.getMazoGuia().setPalo("nulo");
    }
    mostrarTrucosGanados();
    ganadorRonda();
    puntosRonda();
    ganadorJuego();
    vaciarTrucosGanados();
    tablero.pasaRonda();
  }

  public void ganadorTruco(Jugador ganador) {
    ganador.ganoTruco();
  }

  public void ganadorJuego() {
    Lista<Jugador> empates = new Lista();
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    boolean posibleEmpate = false;
    Jugador aux = iteradorLista.next();
    Jugador aux2;
    Jugador auxEmpate = new Jugador("defaut");
    for (int i = 0; i < jugadores.size() - 1; i++) {
      aux2 = iteradorLista.next();
      if (!(aux.getPuntosTotal() > aux2.getPuntosTotal())) {
        aux = aux2;
      }
    }
    Jugador ganadorActl;
    //empates.add(aux);
    iteradorLista = jugadores.iterator();
    for (int i = 0; i < jugadores.size(); i++) {
      ganadorActl = iteradorLista.next();
      if (ganadorActl.getPuntosTotal() == aux.getPuntosTotal()) {
        empates.add(ganadorActl);
        posibleEmpate = true;
      }
    }
    if (posibleEmpate) {
      System.out.println("Ganadores " + empates);
    } else {
      System.out.println("El ganador actual es: " + aux.getNombre());
    }
    /*if (posibleEmpate) {
      if (auxEmpate.getPuntosTotal() == aux.getPuntosTotal()) {
        System.out.println(
          "Jugador " +
          auxEmpate.getNombre() +
          " esta empatado con " +
          aux.getNombre()
        );
      }
    } else {
      System.out.println("El ganador actual es: " + aux.getNombre());
    }*/
  }

  public void puntosRonda() {
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    while (iteradorLista.hasNext()) {
      iteradorLista.next().puntosJugador();
    }
  }

  public void ganadorRonda() {
    Iterator<Jugador> iteradorLista = jugadores.iterator();
    while (iteradorLista.hasNext()) {
      iteradorLista.next().trucosRonda();
    }
  }

  /**
   * Metodo pque sirve para jugar turno, en cada turno todos los jugadores juegan una carta y estas son guardadas en una lista
   * @param tablero Representa el tablero en donde se juega la partida
   * @return Lista<Carta> Representa las cartas jugadas
   */
  public Lista<Carta> jugarTurno(Tablero tablero) {
    Carta aux = new Carta("nulo", "o");
    Carta auxiliar = new Carta("nulo", "g");
    Lista<Carta> cartasJugadas = new Lista<Carta>();
    int i = 0, j = 0;
    System.out.println(
      "El palo triunfo es " + tablero.getMazoTriunfo().toString()
    );
    for (i = 1; i <= jugadores.longi; i++) {
      System.out.println(tablero.getMazoGuia().getPalo());
      if (i > 1) {
        if (tablero.hayMazoGuia()) {
          System.out.println("El palo guía es " + auxiliar.toString());
          System.out.println("El palo  es " + auxiliar.getPalo());
        } else {
          System.out.println("No hay palo guia");
        }
      }
      System.out.println(
        jugadores.elemInd(i).mostrarMano() +
        "Mano del jugador " +
        jugadores.elemInd(i).toString()
      );
      Scanner escan = new Scanner(System.in);
      int ind = 0;
      boolean correcto = true;
      System.out.println("Elige una carta para jugar");

      do {
        correcto = true;
        try {
          ind = escan.nextInt();

          if (ind < 1 || ind > jugadores.elemInd(i).getMano().size()) {
            //ind=0;
            System.out.println("Eleccion no valida");
            throw new InputMismatchException();
          }
        } catch (InputMismatchException ef) {
          escan.nextLine();
          System.out.println(
            "Intenta de nuevo, debes colocar el indice de la carta"
          );
          correcto = false;
        } catch (NullPointerException eg) {
          escan.nextLine();
          System.out.println(
            "Intenta de nuevo, debes colocar el indice de la carta"
          );
          correcto = false;
        }
        // System.out.println(jugadores.elemInd(i).mostrarMano() + "Mano del jugador "  + jugadores.elemInd(i).toString());
        if (correcto == true) {
          aux = jugadores.elemInd(i).jugarCarta(ind);
        }
        if (
          tablero.getMazoGuia().getPalo() == "blanco" ||
          tablero.getMazoGuia().getPalo() == "morado" ||
          tablero.getMazoGuia().getPalo() == "nulo"
        ) {
          tablero.setMazoGuia(aux);
          auxiliar = aux;
        }

        //correcto=true;
        if (correcto == true) {
          if (
            validarJugada(aux, jugadores.elemInd(i).getMano(), tablero) == true
          ) {
            cartasJugadas.agregaFinal(aux);
            jugadores.elemInd(i).getMano().delete(aux);
            if (jugadores.elemInd(i).getMano().isEmpty()) {
              System.out.println(
                "El jugador " +
                jugadores.elemInd(i).toString() +
                " ya no tiene cartas"
              );
            } else {
              System.out.println(
                jugadores.elemInd(i).mostrarMano() +
                "Mano del jugador " +
                jugadores.elemInd(i).toString()
              );
            }
          } else {
            System.out.println("Movimiento invalido");
            correcto = false;
          }
        }
      } while (correcto == false);
    }
    //tablero.getMazoGuia().setPalo("nulo");
    return cartasJugadas;
  }

  public Jugador ganador(Lista<Carta> cartasJugadas, Tablero tablero) {
    Carta mago = new Carta("morado", "W");
    int jokers = 0;
    int indDev = 0;

    for (int i = 1; i <= cartasJugadas.size(); i++) {
      if (cartasJugadas.elemInd(i).getPalo() == "blanco") {
        jokers++;
      }
    }
    if (jokers == cartasJugadas.size()) {
      return this.jugadores.elemInd(1);
    }

    for (int i = 1; i <= cartasJugadas.size(); i++) {
      if (cartasJugadas.elemInd(i).getPalo() == "morado") {
        return this.jugadores.elemInd(i);
      }
    }

    int a = 0;
    int b = 0;
    for (int i = 1; i <= cartasJugadas.size(); i++) {
      if (
        cartasJugadas.elemInd(i).getPalo() == tablero.getMazoTriunfo().getPalo()
      ) {
        indDev = i;
        for (int k = 1; k <= cartasJugadas.size(); k++) {
          if (cartasJugadas.elemInd(i).getValor() != "J") {
            a = Integer.valueOf(cartasJugadas.elemInd(i).getValor());
          }
          if (cartasJugadas.elemInd(k).getValor() != "J") {
            b = Integer.valueOf(cartasJugadas.elemInd(k).getValor());
          }
          if (
            (a < b || (a == 0 && b == 0)) &&
            (
              cartasJugadas.elemInd(k).getPalo() ==
              tablero.getMazoTriunfo().getPalo()
            )
          ) {
            indDev = k;
          }
        }
        return this.jugadores.elemInd(indDev);
      }
    }

    for (int i = 1; i <= cartasJugadas.size(); i++) {
      if (
        cartasJugadas.elemInd(i).getPalo() == tablero.getMazoGuia().getPalo()
      ) {
        indDev = i;
        for (int k = 1; k <= cartasJugadas.size(); k++) {
          if (cartasJugadas.elemInd(i).getValor() != "J") {
            a = Integer.valueOf(cartasJugadas.elemInd(i).getValor());
          }
          if (cartasJugadas.elemInd(k).getValor() != "J") {
            b = Integer.valueOf(cartasJugadas.elemInd(k).getValor());
          }
          if (
            (a < b || (a == 0 && b == 0)) &&
            (
              cartasJugadas.elemInd(k).getPalo() ==
              tablero.getMazoGuia().getPalo()
            )
          ) {
            indDev = k;
          }
        }
        return this.jugadores.elemInd(indDev);
      }
    }

    /*
for(int i=1; i<=cartasJugadas.size(); i++){
for(int k=1; k<=cartasJugadas.size(); k++){
  if(cartasJugadas.elemInd(i).getValor()!="J"){
    a =Integer.valueOf(cartasJugadas.elemInd(i).getValor());
  }
  if(cartasJugadas.elemInd(k).getValor()!="J"){
    b =Integer.valueOf(cartasJugadas.elemInd(k).getValor());
  }
   if(a <= b){
     indDev=k;
   }
 }
 return this.jugadores.elemInd(indDev);
}*/
    return this.jugadores.elemInd(indDev);
  }
}
