
package trainSim.modelo;

import javax.lang.model.SourceVersion;

/**
 *
 * @author David
 */
public class EstacionTren {
    private String name;
    private Float xPos;
    private Float yPos;

    public EstacionTren() {
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
    public Float getxPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setxPos(Float xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public Float getyPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setyPos(Float yPos) {
        this.yPos = yPos;
    }
    
    
}
