/**
 * @author Mauricio Rubio Haro
 * @author Kevin Isaac Alcantara Estrada
 */
package wizard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.util.Iterator;
import wizard.src.*;

public class Archivo {

  final String fileName = "historial.txt";

  public void Historial(Juego juego, Tablero tablero) {
    crearArchivo(fileName);
    pintarArchivo(fileName, juego, tablero);
  }

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
      myWriter.close();
    } catch (IOException e) {
      System.out.println("ERROR 404");
    }
  }
}
