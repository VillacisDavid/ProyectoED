
package moduloApp.modelo;

/**
 *
 * @author David
 */
public class Tarjeta {
    private final String codigo;
    private final Float fondo;

    public Tarjeta(String codigo, Float fondo) {
        this.codigo = codigo;
        this.fondo = fondo;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return the fondo
     */
    public Float getFondo() {
        return fondo;
    }
    
    
    
}
