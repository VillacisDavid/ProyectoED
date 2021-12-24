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

public class Usuario implements Serializable {

    private String username;
    private String password;
    private int tipo;
    private boolean activo;
    private boolean logueado;

    public Usuario(String username, String password, int tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
        this.activo = true;
        this.logueado = false;
    }

    public String getUsuario() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActivo() {
        return activo;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean ingresar(String usu, String pass) {
        if (this.getUsuario().equalsIgnoreCase(usu)
                && this.password.equals(pass)
                && this.isActivo()
                && !this.isLogueado()) {
            this.logueado = true;
            return true;
        }
        return false;
    }

    public boolean salir() {
        if (isLogueado()) {
            this.logueado = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Login{" + "username=" + username + ", password=" + password + ", tipo=" + tipo + ", activo=" + activo + ", logueado=" + logueado + '}';
    }

}
