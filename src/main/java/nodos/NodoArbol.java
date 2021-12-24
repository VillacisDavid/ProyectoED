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
import elementos.Empleado;
import java.io.Serializable;

public class NodoArbol implements Serializable{
    public Empleado empleado;
    public NodoArbol hijo;
    public NodoArbol hermano;
    
    public NodoArbol(Empleado e) {
        empleado = e;
        hijo = null;
        hermano = null;
    }
}
