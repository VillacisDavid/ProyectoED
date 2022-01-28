
package moduloApp.modelo;

/**
 *
 * @author Katherine Ambrosio, Cristhian Hinostroza y David Villacis
 */
public class Trabajador extends Usuario {
    
    private final String tarjeta;
    public Trabajador(Integer userID, String Nombre, int DNI, String tarjeta){
        super(userID, Nombre, DNI);
        this.tarjeta=tarjeta;   
    }

}
