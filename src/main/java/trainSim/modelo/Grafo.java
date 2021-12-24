
package trainSim.modelo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Grafo {
    private int size;
    private ArrayList<EstacionTren> estaciones = new ArrayList<EstacionTren>();
    private Integer[][] relaciones;
    
    
    public Grafo() throws IOException{
        this.abrirGrafo();
    }
    
    public void abrirGrafo() throws IOException{
        try{
            // Poner direccion del archivo grafo1.txt
            File f = new File("recursos\\grafo1.txt");//"C:\\Users\\david\\OneDrive\\Documents\\ED\\ProyectoED\\src\\main\\java\\recursos\\grafo1.txt");
            Scanner scanner = new Scanner(f);
            size = scanner.nextInt();
            
            //Recuperar coordenadas y nombre
            for(int i=0; i<size;i++){
                EstacionTren e = new EstacionTren();
                e.setxPos(scanner.nextFloat());
                e.setyPos(scanner.nextFloat());
                e.setName(scanner.next());
                getEstaciones().add(e);
            }
            
            //Recuperar relaciones
            setRelaciones(new Integer[size][size]);
            for(int i=0; i<size;i++){
                for(int j=0; j<size;j++){
                    getRelaciones()[i][j] = scanner.nextInt();
                }
            }
            
            scanner.close();
            System.out.println("Grafo cargado con exito");
            
        }catch(IOException e){
            System.out.println("error");
            System.out.println(e.getStackTrace());
        }
    }
    
    public void mostrarGrafo(){
        
        for(int i=0; i<size;i++){
            System.out.println(getEstaciones().get(i).getName()+
                    " x = " + getEstaciones().get(i).getxPos() +
                    " y = " + getEstaciones().get(i).getyPos() );
        }
        
        System.out.println("Matriz de relaciones:");
        
        for(int i=0; i<size;i++){
            String line = "";
            for(int j=0; j<size;j++){
                    line = line + getRelaciones()[i][j].toString() + " ";
            }
            System.out.println(line);
        }
        
        
    }

    /**
     * @return the estaciones
     */
    public ArrayList<EstacionTren> getEstaciones() {
        return estaciones;
    }

    /**
     * @param estaciones the estaciones to set
     */
    public void setEstaciones(ArrayList<EstacionTren> estaciones) {
        this.estaciones = estaciones;
    }

    /**
     * @return the relaciones
     */
    public Integer[][] getRelaciones() {
        return relaciones;
    }

    /**
     * @param relaciones the relaciones to set
     */
    public void setRelaciones(Integer[][] relaciones) {
        this.relaciones = relaciones;
    }
    
    
}
