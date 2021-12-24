/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author User
 */
import elementos.Mensaje;
import java.io.Serializable;

public class NodoMensaje implements Serializable {

    public Mensaje mensaje;
    public NodoMensaje siguiente;

    public NodoMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
        this.siguiente = null;
    }


}
