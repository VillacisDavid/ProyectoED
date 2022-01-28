
package trainSim.modelo;

/**
 *
 * @author David
 */
public class EstacionTren { //nodo estacion
    private String name;
    private Integer xPos;
    private Integer yPos;
    private EstacionTren siguiente = null;

    public EstacionTren() {
        this.name = "";
        this.xPos = 0;
        this.yPos = 0;
    }

    public EstacionTren(String name, Integer xPos, Integer yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the xPos
     */
    public Integer getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public Integer getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the siguiente
     */
    public EstacionTren getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(EstacionTren siguiente) {
        this.siguiente = siguiente;
    }

    
    
}
