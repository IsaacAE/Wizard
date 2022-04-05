public class Carta{
    public static final String amarillo = "\u001B[33m";
    public static final String rojo = "\u001B[31m";
    public static final String verde = "\u001B[32m";
    public static final String azul = "\u001B[34m";
    public static final String morado = "\u001B[35m";
    public static final String blanco = "\u001B[37m";

    String palo;
    String valor;
    boolean especial;

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
