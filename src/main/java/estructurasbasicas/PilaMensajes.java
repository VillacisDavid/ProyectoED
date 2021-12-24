/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasbasicas;

/**
 *
 * @author User
 */
import nodos.NodoMensaje;
import elementos.Mensaje;
import java.io.Serializable;

public class PilaMensajes implements Serializable{

    public NodoMensaje cima;
    private int longitud;

    public PilaMensajes() {
        cima = null;
        longitud = 0;
    }

    //¿La pila está vacía?
    public boolean isEmpty() {
        return cima == null;
    }

    //Obtener cima
    public Mensaje peek() {
        if (cima == null) {
            return null;
        }
        return cima.mensaje;
    }

    //Apilar
    public void apilar(Mensaje m) {
        NodoMensaje nuevo_nodo = new NodoMensaje(m);
        nuevo_nodo.siguiente = cima;
        cima = nuevo_nodo;
        longitud++;
    }

    //Desapilar
    public void desapilar() {
        if (isEmpty()) {
            return;
        }
        cima = cima.siguiente;
        longitud--;
    }

    public int nElementos() {
        return longitud;
    }

}

