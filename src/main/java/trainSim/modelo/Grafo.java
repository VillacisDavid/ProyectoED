
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
    private Integer[][] pesos;
    
    
    public Grafo() throws IOException{
        this.abrirGrafo();
    }   
    
    public void Astar(){
        
        
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
                estaciones.add(e);
            }
            
            //Recuperar relaciones
            relaciones = new Integer[size][size];
            for(int i=0; i<size;i++){
                for(int j=0; j<size;j++){
                    relaciones[i][j] = scanner.nextInt();
                }
            }
            
            //Recuperar pesos
            pesos = new Integer[size][size];
            for(int i=0; i<size;i++){
                for(int j=0; j<size;j++){
                    pesos[i][j] = scanner.nextInt();
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
            System.out.println(estaciones.get(i).getName()+
                    " x = " + estaciones.get(i).getxPos() +
                    " y = " + estaciones.get(i).getyPos() );
        }
        
        System.out.println("Matriz de relaciones:");
        
        for(int i=0; i<size;i++){
            String line = "";
            for(int j=0; j<size;j++){
                    line = line + relaciones[i][j].toString() + " ";
            }
            System.out.println(line);
        }
        
        System.out.println("Matriz de pesos:");
        
        for(int i=0; i<size;i++){
            String line = "";
            for(int j=0; j<size;j++){
                    line = line + pesos[i][j].toString() + " ";
            }
            System.out.println(line);
        }
    }
}
