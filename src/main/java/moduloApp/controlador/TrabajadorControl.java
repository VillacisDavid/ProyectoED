
package moduloApp.controlador;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

import moduloLogin.controlador.LoginControl;
import moduloLogin.modelo.Logger;

import moduloApp.modelo.*;
import moduloApp.vista.*;

import trainSim.controlador.TrainSim;

/**
 *
 * @author David
 */
public class TrabajadorControl {
    private InicioTrabajador inicio = new InicioTrabajador();
    private Logger logger = new Logger();
    private Integer userID;
    private Trabajador currentUser;
    private TrainSim ts;  
    
    
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
        *   Labels
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
                
                //Falta validacioon de campos
                
                String nombre = cu.txtNombre.getText();
                int dni = Integer.parseInt(cu.txtDNI.getText());
                String usuario = cu.txtUsername.getText();
                int tipo;
                if(cu.cbxIsAdmin.isSelected()){
                    tipo=1;
                }else{
                    tipo=0;
                }
                if(Arrays.equals(cu.pwfContrasena1.getPassword(), cu.pwfContrasena2.getPassword())){
                    String contrasena = new String(cu.pwfContrasena1.getPassword());
                    //El logger crea el usuario
                    logger.crearUsuario(nombre, dni, usuario, tipo, contrasena);
                    cu.dispose();
                    inicio.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Las contraseñas ingresadas no coinciden");
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
