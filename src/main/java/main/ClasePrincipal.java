/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author User
 */


import elementos.Bus;
import librerias.SerializadoraGen;
import SistemaFinal.sistema;


public class ClasePrincipal {

    public static void main(String[] args) {
        Bus bus01 = new Bus("A", 0);
        Bus bus02 = new Bus("B", 1);
        Bus bus03 = new Bus("C", 2);
        Bus bus04 = new Bus("D", 3);
        Bus bus05 = new Bus("EX1", 4);
        Bus bus06 = new Bus("EX2", 5);
        Bus bus07 = new Bus("EX3", 6);
        Bus bus08 = new Bus("EX4", 7);
        Bus bus09 = new Bus("EX5", 8);
        Bus bus10 = new Bus("EX6", 9);
        Bus bus11 = new Bus("EX7", 10);
        Bus bus12 = new Bus("EX8", 11);
        Bus bus13 = new Bus("SX9", 12);
        Bus bus14 = new Bus("SX", 13);
        Bus bus15 = new Bus("SXN", 14);

        sistema.buses.agregar(bus01);
        sistema.buses.agregar(bus02);
        sistema.buses.agregar(bus03);
        sistema.buses.agregar(bus04);
        sistema.buses.agregar(bus05);
        sistema.buses.agregar(bus06);
        sistema.buses.agregar(bus07);
        sistema.buses.agregar(bus08);
        sistema.buses.agregar(bus09);
        sistema.buses.agregar(bus10);
        sistema.buses.agregar(bus11);
        sistema.buses.agregar(bus12);
        sistema.buses.agregar(bus13);
        sistema.buses.agregar(bus14);
        sistema.buses.agregar(bus15);

//       DESERIALIZACIÓN
        sistema.estaciones.setEstaciones(SerializadoraGen.deserializar(sistema.FILE_ESTACIONES));
        sistema.usuarios.setUsuarios(SerializadoraGen.deserializar(sistema.FILE_USUARIOS));
        sistema.movimientosTarjeta.setMovimientos(SerializadoraGen.deserializar(sistema.FILE_MOVIMIENTOSTARJETA));
        sistema.movimientosViaje.setMovimientos(SerializadoraGen.deserializar(sistema.FILE_MOVIMIENTOSVIAJE));
        sistema.clientes = SerializadoraGen.deserializarClientes(sistema.FILE_CLIENTES);
       sistema.empleados = SerializadoraGen.deserializarEmpleados(sistema.FILE_EMPLEADOS);
        sistema.mensajesClientes = SerializadoraGen.deserializarMensajesClientes(sistema.FILE_COLAMENSAJES);

  

    }
}
