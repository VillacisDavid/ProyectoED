
package moduloApp.controlador;
//Dependencias
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

//  Modulo actual: Cliente
import moduloApp.vista.*;
import moduloApp.modelo.*;

//  Importar para volver al login al cerrar sesion
import moduloLogin.controlador.LoginControl;

//  Importar Simulador
import trainSim.controlador.TrainSim;

/**
 *
 * @author Katherine Ambrosio, Cristhian Hinostroza y David Villacis
 */
public class ClienteControl{
    private InicioCliente inicio = new InicioCliente();
    private Cliente currentUser;
    private TrainSim ts;
    private ColaMensajes cola;
    private Serializador serial = new Serializador();
    
    public ClienteControl(Cliente User) throws IOException{
        try{
            ts = new TrainSim();
        }catch(IOException e){
            System.out.println("No se encontro el archivo");
        }
        
        currentUser = User;
        
        
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
        
        /*
        *   Labels
        */
        
        inicio.lblBienvenido.setText("Bienvenido, "+currentUser.getNombre());        
        
        /*
        *   Accion del boton Seleccionar ruta
        */
        
        inicio.btnRutaDjikstra.addActionListener((ActionEvent a) -> {
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
        inicio.btnVecCompra.addActionListener((ActionEvent a) -> {
            inicio.setVisible(false);
            inicio.setVisible(true);
            
        });
        
        /*
        *   Accion del boton Contactenos
        */
        inicio.btnContacto.addActionListener((ActionEvent a) -> {
            EnviarMensajes env = new EnviarMensajes();
            inicio.setVisible(false);
            env.setVisible(true);
            env.setLocationRelativeTo(null);
            
            //enviar mensaje (encolar)
            env.btnEnviar.addActionListener((ActionEvent e) -> {
                //Recoger campos
                String asunto = env.txtAsunto.getText();
                String mensaje = env.txtMensaje.getText();
                String emisor = currentUser.getNombre();
                
                Mensaje m = new Mensaje(emisor,asunto,mensaje,null);
                
                    //Encolar mensaje
                //deserializar archivo
                cola=serial.deserializarMensajes("recursos\\colaMensajes.ser");
                //encolar
                cola.insertar(m);
                JOptionPane.showMessageDialog(null, "Mensaje enviado");
                //serializar
                serial.serializarMensajes("recursos\\colaMensajes.ser", cola);
                env.dispose();
                inicio.setVisible(true);
            });
            
            env.btnVolver.addActionListener((ActionEvent e) -> {
                env.dispose();
                inicio.setVisible(true);
            });
            
        });
        
        /*
        *   Accion del boton cerrar sesion
        */
        
        inicio.Logout.addActionListener((ActionEvent e) -> {
            inicio.dispose();
            currentUser=null;
            new LoginControl();
        }); 
    }    
    
     /**
     * @return the currentUser
     */
    public Cliente getCurrentUser() {
        return currentUser;
    }
    
    
}
