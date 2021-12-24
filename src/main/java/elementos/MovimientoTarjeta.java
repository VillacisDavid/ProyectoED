/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author User
 */
import java.io.Serializable;
import java.util.Date;

public class MovimientoTarjeta implements Serializable {

    //id de la tarjeta que realizó el movimiento
    private final int idTarjeta;
    //estación en dónde se realizó el movimiento
    private final String estacion;

    private final Date fecha;
    private final double monto;

    public MovimientoTarjeta(int idTarjeta, String estacion, double monto) {
        this.idTarjeta = idTarjeta;
        this.estacion = estacion;
        this.fecha = new Date();
        this.monto = monto;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public String getEstacion() {
        return estacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

}
