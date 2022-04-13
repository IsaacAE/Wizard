/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;

import java.util.Random;
import java.util.Random;
import wizard.src.Estructuras.*;

public class Baraja {

  String palo;
  // int tam=13;
  Carta[] mazoCartas;

  public Baraja(String palo) {
    this.palo = palo;

    if (palo == "blanco") {
      mazoCartas = new Carta[4];
      for (int i = 0; i < 4; i++) {
        this.mazoCartas[i] = new Carta(palo, "J");
      }
    } else if (palo == "morado") {
      mazoCartas = new Carta[4];
      for (int i = 0; i < 4; i++) {
        this.mazoCartas[i] = new Carta(palo, "W");
      }
    } else {
      mazoCartas = new Carta[13];
      String num = "";

      for (int i = 0; i < 13; i++) {
        int number = i + 1;

        num = number + "";
        this.mazoCartas[i] = new Carta(palo, num);
      }
    }
    //this.Carta[];

  }

  public Baraja(Carta[] mazoCartas) {
    this.mazoCartas = mazoCartas;
    this.palo = "nulo";
  }

  public Baraja() {
    this.palo = "neutro";
    int j = 0;
    String num = "";
    this.mazoCartas = new Carta[60];
    for (int i = 0; i < 13; i++) {
      int number = i + 1;
      num = number + "";
      this.mazoCartas[j] = new Carta("verde", num);
      j++;
    }

    for (int i = 0; i < 4; i++) {
      this.mazoCartas[j] = new Carta("blanco", "J");
      j++;
    }

    for (int i = 0; i < 4; i++) {
      this.mazoCartas[j] = new Carta("morado", "W");
      j++;
    }

    for (int i = 0; i < 13; i++) {
      int number = i + 1;
      num = number + "";
      this.mazoCartas[j] = new Carta("azul", num);
      j++;
    }

    for (int i = 0; i < 13; i++) {
      int number = i + 1;
      num = number + "";
      this.mazoCartas[j] = new Carta("amarillo", num);
      j++;
    }

    for (int i = 0; i < 13; i++) {
      int number = i + 1;
      num = number + "";
      this.mazoCartas[j] = new Carta("rojo", num);
      j++;
    }
  }

  public String toString() {
    String mazo = "";
    for (int j = 0; j < this.mazoCartas.length; j++) {
      if (mazoCartas[j] != null) {
        mazo += mazoCartas[j].toString();
      }
    }
    return mazo;
  }

  public void cambiarCarta(int indice1, int indice2) {
    Carta aux = mazoCartas[indice1];
    mazoCartas[indice1] = mazoCartas[indice2];
    mazoCartas[indice2] = aux;
  }

  public Carta[] revolver() {
    int azar = 0;
    int j = 0;
    for (int i = 0; i < mazoCartas.length; i++) {
      //j = i;
      azar = (int) (Math.random() * (mazoCartas.length - 1));
      // mazoCartas.cambiarCarta(i, azar);
      Carta aux = mazoCartas[i];
      mazoCartas[i] = mazoCartas[azar];
      mazoCartas[azar] = aux;
    }
    return this.mazoCartas;
  }

  public Carta sacarCarta() {
    Carta aux = new Carta("neutro", "0");
    for (int i = 0; i < mazoCartas.length; i++) {
      if (mazoCartas[i] != null) {
        aux = mazoCartas[i];
        mazoCartas[i] = null;
        return aux;
      }
    }

    return aux;
  }

  public String getPalo() {
    return this.palo;
  }

  public Carta[] getMazoCartas() {
    return this.mazoCartas;
  }

  public void setMazoCartas(Carta[] mazoCartas) {
    this.mazoCartas = mazoCartas;
  }

  public void setPalo(String palo) {
    this.palo = palo;
  }

  public Carta cartaIndex(int index){
    return this.mazoCartas[index];
  }
  
}
