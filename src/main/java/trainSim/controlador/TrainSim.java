
package trainSim.controlador;

import trainSim.modelo.Grafo;

import java.io.IOException;
import java.util.ArrayList;
import trainSim.modelo.EstacionTren;



/**
 *
 * @author David
 */
public class TrainSim {
    
    private Grafo g;
    
    public TrainSim() throws IOException{
        
        this.g = new Grafo();
        
    }
    
    public void mostrarMapa(){
        
        
    }
    
    public EstacionTren getRuta(String origen, String destino){
        
        ArrayList<EstacionTren> a = g.getEstaciones();
        Integer[][] b = g.getRelaciones();
        EstacionTren lista = new EstacionTren();
        
        // Algoritmo de busqueda que devuelva
        
        
        return lista;
    }
    
    public void mostrarRuta(){
        
        
    }

}
