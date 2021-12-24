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
public enum EnumTipoTarjeta {

    GENERAL("GENERAL", 1.0),
    ESCOlAR("ESCOLAR", 0.5),
    UNIVERSITARIO("UNIVERSITARIO", 0.75);

    private final String nombreTarjeta;
    private double porcentaje;

    private EnumTipoTarjeta(String nombreTarjeta, double porcentaje) {
        this.nombreTarjeta = nombreTarjeta;
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public String getNombre() {
        return nombreTarjeta;
    }
}
