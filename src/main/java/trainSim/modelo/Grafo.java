
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
    
    public void abrirGrafo() throws IOException{
        try{
            // Poner direccion del archivo grafo1.txt
            File f = new File("recursos\\grafo1.txt");//"C:\\Users\\david\\OneDrive\\Documents\\ED\\ProyectoED\\src\\main\\java\\recursos\\grafo1.txt");
            Scanner scanner = new Scanner(f);
            size = scanner.nextInt();
            
            //Recuperar coordenadas y nombre
            for(int i=0; i<getSize();i++){
                EstacionTren e = new EstacionTren();
                e.setxPos(scanner.nextInt());
                e.setyPos(scanner.nextInt());
                e.setName(scanner.next());
                getEstaciones().add(e);
            }
            
            //Recuperar relaciones
            setRelaciones(new Integer[getSize()][getSize()]);
            for(int i=0; i<getSize();i++){
                for(int j=0; j<getSize();j++){
                    getRelaciones()[i][j] = scanner.nextInt();
                }
            }
            
            //Generar pesos
            pesos = new Integer[getSize()][getSize()];
            for(int i=0;i<getSize();i++){
                for(int j=0;j<getSize();j++){
                    if(relaciones[i][j]==1){
                        double dx=estaciones.get(i).getxPos()-estaciones.get(j).getxPos();
                        double dy=estaciones.get(i).getyPos()-estaciones.get(j).getyPos();
                        pesos[i][j]= (int)Math.sqrt(dx*dx+dy*dy);
                    }else{
                        pesos[i][j]=-1;
                    }
                }
            }
            
            scanner.close();
            System.out.println("Grafo cargado con exito");
            
        }catch(IOException e){
            System.out.println("error");
            System.out.println(e.getStackTrace());
        }
    }
    
    @Override
    public String toString(){ // devuelve un string con la informacion del grafo
        String Response = new String("");
        
        for(int i=0; i<getSize();i++){
            Response = Response + getEstaciones().get(i).getName() +
                    " x = " + getEstaciones().get(i).getxPos().toString()
                    + " y = " + getEstaciones().get(i).getyPos().toString()
                    + "\n";
        }
        
        Response += "Matriz de relaciones:\n";
        
        for(int i=0; i<getSize();i++){
            String line = "";
            for(int j=0; j<getSize();j++){
                    line = line + getRelaciones()[i][j].toString() + " ";
            }
            Response += line;
            Response += "\n";
            
        }
        
        Response += "Matriz de pesos:\n";
        
        for(int i=0; i<getSize();i++){
            String line = "";
            for(int j=0; j<getSize();j++){
                    line = line + getPesos()[i][j]+ " ";
            }
            Response += line;
            Response += "\n";
        }
        
        return Response;
        
    }
    
    public ListaEstaciones dijkstra(String salida, String destino){
        ListaEstaciones lista = new ListaEstaciones(); 
        /*
        *   Extraer indices de las estaciones
        */
        int iOrigen = getIndexOf(salida);
        int iDestino = getIndexOf(destino);
        
        
        /*
        *   Aplicar algoritmo dijkstra
        */
        
        //  To do
        
        lista.insertar(estaciones.get(iOrigen));
        lista.insertar(estaciones.get(iDestino));
        
        
        return lista;
    }
    
    /*
    *   @return Indice de la estacion en el ArrayList estaciones
    */
    
    public Integer getIndexOf(String nombreEstacion){
        int indice=-1;
        
        for(int i=0;i<getSize();i++){
            if(nombreEstacion.equals(estaciones.get(i).getName()) ){
                indice=i;
            }
        }
        
        return indice;
    }

    /**
     * @return the estaciones
     */
    public ArrayList<EstacionTren> getEstaciones() {
        return estaciones;
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

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the pesos
     */
    public Integer[][] getPesos() {
        return pesos;
    }
    
    
}
