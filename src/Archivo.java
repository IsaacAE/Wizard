/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import wizard.src.*;

public class Archivo {

  final String fileName = "historial.txt";

  /**
   * Metodo para crear nuestro archivo e imprimir en el los datos que 
   * queremos guardar a parir del obejto juego y tablero
   * @param Juego
   * @param Tablero
   */
  public void Historial(Juego juego, Tablero tablero) {
    crearArchivo(fileName);
    pintarArchivo(fileName, juego, tablero);
  }

  /**
   * Metodo para crear un archivo, en caso de que ya exista este 
   * se remplazara por uno nuevo, el argumento es el nombre del 
   * archivo
   * @param String
   */
  public void crearArchivo(String fileName) {
    try {
      File myObj = new File(fileName);
      if (myObj.createNewFile()) {
        System.out.println("Archivo creado " + myObj.getName());
      } else {
        System.out.println("Archivo ya existe, reemplazando");
        if (myObj.delete()) {
          crearArchivo(fileName);
        }
      }
    } catch (IOException e) {
      System.out.println("Error");
      e.printStackTrace();
    }
  }

  /**
   * Metodo para pintar sobre el archivo todo lo que necesitamos
   * a partir del objeto juego y tablero en el archivo con nombre
   * fileName
   * @param fileName
   * @param Juego
   * @param Tablero
   */
  public void pintarArchivo(String fileName, Juego juego, Tablero tablero) {
    try {
      Iterator<Jugador> iteradorLista = juego.getJugadores().iterator();
      FileWriter myWriter = new FileWriter(fileName);
      myWriter.write("Jugadores: \n " + juego.getJugadores()+"\n");
      Jugador aux;
      while (iteradorLista.hasNext()) {
        aux = iteradorLista.next();
        myWriter.write("\nJugador: " + aux.getNombre());
        myWriter.write(
          "\nBarajeo las siguientes rondas : \n" + aux.getBarajeo()
        );
        myWriter.write("jugo las siguientes cartas (respectivamente): " + aux.getJugadas()+"\n");
        myWriter.write("acumulo lo siguientes puntos (respectivamente): " + aux.getRondaPuntos()+"\n");
        myWriter.write("total de puntos " + aux.getPuntosTotal()+"\n");
      }
      myWriter.write(
        "\nSe jugo con las siguientes barajas (respectivamente) : \n" +
        tablero.getBarajas()
      );
      if(juego.getPosibleEmpate()){
        myWriter.write("\n Ganadores: \n "+juego.getEmpates());
      }else{
        myWriter.write("\n Ganador: "+juego.getGanador());
      }
      
      myWriter.close();
    } catch (IOException e) {
      System.out.println("ERROR 404");
    }
  }
}
