/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard.src;
import wizard.src.Estructuras.*;
import java.util.Random;

public class Baraja{

    String palo;
   // int tam=13;
    Carta[] mazoCartas;


    public Baraja(String palo){
        this.palo = palo;

        if(palo=="blanco"){
           mazoCartas = new Carta[4];
            for(int i=0;i<4; i++){
                this.mazoCartas[i]= new Carta(palo, "J");
             }
            }else if(palo=="morado"){
                mazoCartas = new Carta[4];
            for(int i=0;i<4; i++){
                this.mazoCartas[i]= new Carta(palo, "W");
             }
            }else{
                mazoCartas = new Carta[12];
                String num= "";
                
            for(int i=0;i<12; i++){
                int number = i+1;

                num = number+"";
                this.mazoCartas[i]= new Carta(palo, num);
             }
        }

        //this.Carta[];

    }

    public String toString(){
        String mazo="";
        for(int j=0; j<this.mazoCartas.length; j++){
            mazo += mazoCartas[j].toString();
            
        }
        return mazo;
    }

    public void cambiarCarta(int indice1, int indice2){
        Carta aux = mazoCartas[indice1];
        mazoCartas[indice1]= mazoCartas[indice2];
        mazoCartas[indice2] = aux;
    }

    public Carta[] revolver(){
        int azar = 0;
        int j=0;
        for(int i = 0; i<mazoCartas.length; i++){
         //j = i;
        azar = (int) ( Math.random() * (mazoCartas.length-1));
       // mazoCartas.cambiarCarta(i, azar);
        Carta aux = mazoCartas[i];
        mazoCartas[i]= mazoCartas[azar];
        mazoCartas[azar] = aux;
        
        }
        return this.mazoCartas;
    }

    public Carta sacarCarta(){
	Carta aux = new Carta("neutro", "0");
	for(int i=0; i<mazoCartas.length; i++){
	    if(mazoCartas[i]!=null){
		 aux = mazoCartas[i];
		mazoCartas[i]= null;
		return aux;
	    }
	}

	return aux; 
    }
}

