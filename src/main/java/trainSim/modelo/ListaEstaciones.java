
package trainSim.modelo;

/**
 *
 * @author David
 */
public class ListaEstaciones {
    private EstacionTren lista;
    private Integer longitud;
    
    public ListaEstaciones(){
        lista = null;
        longitud = 0;        
    }
    
    //Crea un objeto duplicado del nodo
    private EstacionTren newNodo(EstacionTren et){
        EstacionTren nuevo = new EstacionTren();
        nuevo.setName(et.getName());
        nuevo.setSiguiente(null);
        nuevo.setxPos(et.getxPos());
        nuevo.setyPos(et.getyPos());
        return nuevo;
    }
    
    //Inserta al final
    public void insertar(EstacionTren et){
        EstacionTren i=lista;
        EstacionTren q=newNodo(et);
        if(lista==null){
            lista=q;
        }else{
            while(i.getSiguiente()!= null){
                i=i.getSiguiente();
            }
            i.setSiguiente(et);
        }
        longitud++;
    }
    
    public void eliminarPrimero(){
        EstacionTren i=lista;
        if(lista==null){
            //nada
        }else{
            lista=lista.getSiguiente();
            i=null;
        }
        
    }
    
    /*
    *   devielve 0(eliminacion fallida) o 1(eliminacion exitosa)
    */
    public int eliminarPos(int n){
        EstacionTren i=lista;
        int c=1;
        if(n>longitud){
            return 0;
        }else if(n==1){
            eliminarPrimero();
            return 1;
        }else{
            while(c!=n-1){
                i=i.getSiguiente();
                c++;
            }
            
            return 1;
        }
    }
    
    //muestra los nombres de las estaciones
    public String mostrar(){
        String respuesta=" ";
        EstacionTren i=lista;
        Integer index = 1; 
        
        if(lista==null){
            respuesta="Lista vacia";
        }else{
            while(i!= null){
                respuesta = respuesta + index.toString() +". "+ i.getName() + "\n";
                i=i.getSiguiente();
                index++;
            }
        }
        
        return respuesta;
    }
    
}
