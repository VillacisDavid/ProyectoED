
package trainSim.modelo;

/**
 *
 * @author David
 * Inserta y elimina del inicio
 */
public class stackEstaciones {
    private EstacionTren stack;
    private Integer longitud;
    
    public stackEstaciones(){
        stack = null;
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
    
    //Inserta al inicio
    public void push(EstacionTren et){
        EstacionTren q=newNodo(et);
        if(stack!=null){
            q.setSiguiente(stack);
        }
        stack = q;
        longitud++;
    }
    
    //Elimina del inicio
    public void popDelete(){
        if(stack==null){
            System.out.println("lista vacia");
        }else{
            stack = stack.getSiguiente();
        }
        longitud--;
    }
    
    //Hace pop y devuelve el elemento eliminado
    public EstacionTren popReturn(){
        EstacionTren i = stack;
        if(stack!=null){
            stack=stack.getSiguiente();
        }
        i.setSiguiente(null);
        return i;
    }
    
    public EstacionTren top(){
        return stack;
    }
    
    //muestra los nombres de las estaciones
    public String mostrar(){
        String respuesta=" ";
        EstacionTren i=stack;
        Integer index = 1; 
        
        if(stack==null){
            respuesta="Lista vacia";
        }else{
            while(i!= null){
                respuesta = respuesta + index.toString() +". "+ i.getName() + " <- ";
                i=i.getSiguiente();
                index++;
            }
        }
        
        return respuesta;
    }

    /**
     * @return the longitud
     */
    public Integer getLongitud() {
        return longitud;
    }
    
}
