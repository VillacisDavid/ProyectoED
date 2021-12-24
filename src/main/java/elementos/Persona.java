/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.io.Serializable;

public class Persona implements Serializable {

    private String dni;
    private String nombres;
    private String usuario;

    public Persona(String dni, String nombres) {
        this.dni = dni;
        this.nombres = nombres.toUpperCase();
    }

    public Persona(String dni, String nombres, String username) {
        this.dni = dni;
        this.nombres = nombres.toUpperCase();
        this.usuario = username;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
