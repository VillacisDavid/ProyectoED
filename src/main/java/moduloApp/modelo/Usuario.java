
package moduloApp.modelo;

/**
 *
 * @author David
 */
public abstract class Usuario {
    private final Integer userID;
    private final String Nombre;
    private final int DNI;
    

    public Usuario(Integer userID, String Nombre, int DNI) {
        this.userID = userID;
        this.Nombre = Nombre;
        this.DNI = DNI;
    }
    
    

    /**
     * @return the userID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @return the DNI
     */
    public int getDNI() {
        return DNI;
    }
    
    
}
