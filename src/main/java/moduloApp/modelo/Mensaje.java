package moduloApp.modelo;

import java.io.Serializable;

/**
 *
 * @author Katherine Ambrosio, Cristhian Hinostroza y David Villacis
 */
public class Mensaje implements Serializable {
    private String emisor;
    private String asunto;
    private String mensaje;
    private Mensaje sgte;

    public Mensaje(String emisor, String asunto, String mensaje, Mensaje sgte) {
        this.emisor = emisor;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.sgte = sgte;
    }

    public Mensaje() {
    }

    
    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the sgte
     */
    public Mensaje getSgte() {
        return sgte;
    }

    /**
     * @param sgte the sgte to set
     */
    public void setSgte(Mensaje sgte) {
        this.sgte = sgte;
    }

    /**
     * @return the emisor
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * @param emisor the emisor to set
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

}
