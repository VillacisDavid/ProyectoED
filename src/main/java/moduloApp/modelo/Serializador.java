package moduloApp.modelo;

import java.io.*;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 *
 * @author David Villacis Alvear
 */
public class Serializador {
    
    public Serializador(){
        
    }
    
    public void serializarMensajes(String nombreArchivo, ColaMensajes cola) {
        try {
            FileOutputStream file = new FileOutputStream(nombreArchivo);
            ObjectOutputStream escritor = new ObjectOutputStream(file);
            escritor.writeObject(cola);
            escritor.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());;
        }
    }

    public ColaMensajes deserializarMensajes(String nombreArchivo) {
        ColaMensajes retorno = new ColaMensajes();
        try {
            FileInputStream file = new FileInputStream(nombreArchivo);
            ObjectInputStream lector = new ObjectInputStream(file);
            retorno = (ColaMensajes) lector.readObject();
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("e = " + e.getMessage());;
        }
        return retorno;
    }
}
