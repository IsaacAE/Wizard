/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 * Clase que emula una carta
 */
package wizard.src;
//import java.applet.*;
//import java.awt.Color;

public class Carta{
    public static final String amarillo = "\u001B[33m";
    public static final String rojo = "\u001B[31m";
    public static final String verde = "\u001B[32m";
    public static final String azul = "\u001B[34m";
    public static final String morado = "\u001B[35m";
    public static final String blanco = "\u001B[37m";
    
    //Atributos de la clase
   	private String palo;
  	private   String valor;
   	private boolean especial;

/**
 * Metodo constructor de la clase
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 * @param palo Color de la carta
 * @param valor Valor de la carta
 */
    public Carta(String palo, String valor){

        this.palo = palo;
        this.valor = valor;
        //this.especial=false;
    }

  /*  public Carta(String valor){

        this.palo = "neutro";
        this.valor = valor;
        //this.especial = true;
    }*/

/**
 * Metodo para obtener el valor de la carta
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 * @return valor 
 */
    public String getValor(){
        return this.valor;

    }

/**
 * Metodo para modificar el valor de la carta
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 * @param valor NUevo valor de la carta
 */
    public void setValor(String valor){
        this.valor = valor;

    }

/**
 * Metodo para modificar el palo de la carta
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 * @param palo Nuevo palo de la carta
 */
    public void setPalo(String palo){
        this.palo = palo;

    }

/**
 * Metodo para obtener el palo de la carta
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 * @return palo
 */
    public String getPalo(){
        return this.palo;

    }


/**
 * Metodo para representar en cadena el objto
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 * @return card 
 */
    public String toString(){
        String card="";
        switch(palo){
            case "verde":
            card = "[" + verde + this.valor + blanco + "]";
           break;

           case "rojo":
            card = "[" + rojo + this.valor + blanco + "]";
           break;

           case "azul":
            card = "[" + azul + this.valor + blanco + "]";
           break;

           case "amarillo":
            card = "[" + amarillo + this.valor + blanco + "]";
           break;

           case "morado":
            card = "[" + morado + this.valor + blanco + "]";
           break;
            
           case "blanco":
            card = "[" + blanco + this.valor + blanco + "]";
           break;
           
        }
        return card;
    }

}
