/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

public class Bus {

    private String tipoBus;
    private int idBus;

    public Bus(String tipoBus, int idBus) {
        this.tipoBus = tipoBus;
        this.idBus = idBus;
    }

    public int getIdBus() {
        return idBus;
    }

    public String getTipoBus() {
        return tipoBus;
    }

}
