/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import elementos.Cliente;
import java.io.Serializable;

public class NodoCliente implements Serializable {

    public Cliente cliente;
    public NodoCliente siguiente;

    public NodoCliente(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }



}
