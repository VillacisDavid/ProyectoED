
package moduloApp.controlador;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

import moduloLogin.controlador.LoginControl;
import moduloLogin.modelo.Logger;

import moduloApp.modelo.*;
import moduloApp.vista.*;

import trainSim.controlador.TrainSim;

/**
 *
 * @author Katherine Ambrosio, Cristhian Hinostroza y David Villacis
 */
public class TrabajadorControl {
    private InicioTrabajador inicio = new InicioTrabajador();
    private Logger logger = new Logger();
    private Trabajador currentUser;
    private TrainSim ts;  
    private ColaMensajes cola;
    private Serializador serial = new Serializador();
    
    public TrabajadorControl(Trabajador User) throws IOException {
        try{
            ts = new TrainSim();
        }catch(IOException e){
            System.out.println("No se encontro el archivo");
        }
        /*
        *   Conectarse a la base de datos y obtener informacion segun el ID de usuario
        */
        currentUser=User;
        
       
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
        
        /*
        *   Label
        */
        inicio.lblBienvenido.setText("Bienvenido, "+currentUser.getNombre());  
        
        /*
        *   Accion del boton crear ruta optima
        */
        inicio.btnRutaOptima.addActionListener((ActionEvent a) -> {
            inicio.setVisible(false);
            ts.initSeleccionRuta();
            ts.getSeleccionar().btnVolver.addActionListener((ActionEvent e) -> {
                ts.getSeleccionar().dispose();
                inicio.setVisible(true); 
            });
        });
        
        /*
        *   Accion del boton Crear ruta
        */
        inicio.btnCrearRuta.addActionListener((ActionEvent a) -> {
            inicio.setVisible(false);
            ts.initCrearRuta();
            ts.getCrear().btnVolver.addActionListener((ActionEvent e) -> {
                ts.getCrear().dispose();
                inicio.setVisible(true); 
            });
        });
        
        /*
        *   Accion del boton Recargar tarjeta
        */
        inicio.btnRecarga.addActionListener((ActionEvent a) -> {
            inicio.setVisible(false);
            inicio.setVisible(true);
            
        });
        
        /*
        *   Accion del boton ver mensajes
        */
        inicio.btnMensajes.addActionListener((ActionEvent a) -> {
            VerColaMensajes vcm = new VerColaMensajes();
            inicio.setVisible(false);
            vcm.setVisible(true);
            vcm.setLocationRelativeTo(null);
            
            cola = serial.deserializarMensajes("recursos\\colaMensajes.ser");
            
            if(cola.getLongitud()>0){
                            
                vcm.lblRemitente.setText(cola.getCola().getEmisor());
                vcm.lblNoLeidos.setText(cola.getLongitud().toString());
                vcm.txtMensaje.setText(cola.getCola().getAsunto()+": \n"+cola.getCola().getMensaje());

                vcm.btnSiguiente.addActionListener((ActionEvent e) -> {
                            //desencolar y mostrar siguiente mensaje
                    //deserializar archivo
                    cola=serial.deserializarMensajes("recursos\\colaMensajes.ser");
                    //desencolar
                    int respuesta = JOptionPane.showConfirmDialog(null, "Se quitara el mensaje actual de la cola. Asegurese de enviar una respuesta",
                                        "Confirmar", JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE);

                    if(respuesta==0){
                        cola.eliminarPrimero();
                    }else{
                        //nada
                    }

                    //re-serializar
                    serial.serializarMensajes("recursos\\colaMensajes.ser",cola);
                    vcm.dispose();
                    inicio.setVisible(true);
                });
            }else{
                JOptionPane.showMessageDialog(null, "No hay mensajes");
                vcm.dispose();
                inicio.setVisible(true);
            }
            
            vcm.btnVolver.addActionListener((ActionEvent e) -> {
                vcm.dispose();
                inicio.setVisible(true);
            });
        });
        
        /*
        *   Accion del boton Crear usuario
        */
        inicio.btnCrearUsuario.addActionListener((ActionEvent a) -> {
            CrearUsuario cu = new CrearUsuario();
            inicio.setVisible(false);
            cu.setVisible(true);
            cu.setLocationRelativeTo(null);
            //accion del boton crear usuario
            cu.btnCrear.addActionListener((ActionEvent c) -> {
                try{
                    String nombre = cu.txtNombre.getText();
                    if(nombre.equals(""))
                        throw new SQLException();
                    int dni = Integer.parseInt(cu.txtDNI.getText());
                    String usuario = cu.txtUsername.getText();
                    if(usuario.equals(""))
                        throw new SQLException();
                    int tipo;
                    if(cu.cbxIsAdmin.isSelected()){
                        tipo=1;
                    }else{
                        tipo=0;
                    }
                    if(Arrays.equals(cu.pwfContrasena1.getPassword(), cu.pwfContrasena2.getPassword())){
                        String contrasena = new String(cu.pwfContrasena1.getPassword());
                        if(contrasena.equals(""))
                            throw new SQLException();
                        //El logger crea el usuario
                        logger.crearUsuario(nombre, dni, usuario, tipo, contrasena);
                        cu.dispose();
                        inicio.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Las contraseñas ingresadas no coinciden");
                    }
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Rellenar todos los campos");
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"DNI invalido");
                }
            });
            
            //accion del boton volver
            cu.btnVolver.addActionListener((ActionEvent c) -> {
                cu.dispose();
                inicio.setVisible(true);
            });
        });
        
        /*
        * Accion del boton cerrar sesion
        */
        
        inicio.Logout.addActionListener((ActionEvent e) -> {
            inicio.dispose();
            currentUser=null;
            new LoginControl();
        });
        
        
    }

}
