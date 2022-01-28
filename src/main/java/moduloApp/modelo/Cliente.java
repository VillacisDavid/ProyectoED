
package moduloApp.modelo;

/**
 *
 * @author David
 */
public class Cliente extends Usuario{
    private final String tarjeta;
    public Cliente(Integer userID, String Nombre, int DNI, String tarjeta){
        super(userID, Nombre, DNI);
        this.tarjeta=tarjeta;   
    }
       
    
}
