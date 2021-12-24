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
import detalles.cargosdesignados;

public class Empleado extends Persona implements Serializable {

    private int idCargo;
    private int nivel;
    private String nombreCargo;
    private int idCargoJefe;
    private double sueldo;

    public Empleado(int idCargo, String dni, String nombres) {
        super(dni, nombres);
        this.idCargo = idCargo;
        this.nivel = (int) cargosdesignados.infoEmpleado[idCargo][0];
        this.nombreCargo = (String) cargosdesignados.infoEmpleado[idCargo][1];
        this.idCargoJefe = (int) cargosdesignados.infoEmpleado[idCargo][2];
        this.sueldo = (double) cargosdesignados.infoEmpleado[idCargo][3];
    }

    //Constructor para los registros iniciales
    public Empleado(int idCargo, String dni, String nombres, String username) {
        super(dni, nombres,username);
        this.idCargo = idCargo;
        this.nivel = (int) cargosdesignados.infoEmpleado[idCargo][0];
        this.nombreCargo = (String) cargosdesignados.infoEmpleado[idCargo][1];
        this.idCargoJefe = (int) cargosdesignados.infoEmpleado[idCargo][2];
        this.sueldo = (double) cargosdesignados.infoEmpleado[idCargo][3];
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public int getIdCargoJefe() {
        return idCargoJefe;
    }

    public double getSueldo() {
        return sueldo;
    }
    public String getNombresYCargo() {
        return super.getNombres() + ")";
    }

}