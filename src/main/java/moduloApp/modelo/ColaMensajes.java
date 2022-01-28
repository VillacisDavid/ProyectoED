package moduloApp.modelo;

/**
 *
 * @author Katherine Ambrosio, Cristhian Hinostroza y David Villacis
 * inserta al final y elimina del inicio
 */
public class ColaMensajes implements java.io.Serializable {
    
    private Mensaje cola;
    private Integer longitud=0;
    //new nodo
    //insertar (al final)
    //eliminar primero
    //get primero
    
    public ColaMensajes(){
        cola = null;
        longitud = 0;        
    }
    private Mensaje newNodo(Mensaje m){
        Mensaje nuevo = new Mensaje();
        nuevo.setEmisor(m.getEmisor());
        nuevo.setAsunto(m.getAsunto());
        nuevo.setMensaje(m.getMensaje());
        nuevo.setSgte(null);
        return nuevo;
    }
    
    //Inserta al final
    public void insertar(Mensaje m){
        Mensaje i=getCola();
        Mensaje q=newNodo(m);
        if(getCola()==null){
            cola=q;
        }else{
            while(i.getSgte()!= null){
                i=i.getSgte();
            }
            i.setSgte(m);
        }
        longitud++;
    }
    
    public void eliminarPrimero(){
        Mensaje i=getCola();
        if(getCola()==null){
            //nada
        }else{
            cola=getCola().getSgte();
            i=null;
        } 
        longitud--;
    }

    /**
     * @return the cola
     */
    public Mensaje getCola() {
        return cola;
    }

    /**
     * @return the longitud
     */
    public Integer getLongitud() {
        return longitud;
    }
    
}
