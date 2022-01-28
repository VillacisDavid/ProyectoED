
package moduloApp.controlador;
//Dependencias
import java.awt.event.ActionEvent;
import java.io.IOException;

//  Modulo actual: Cliente
import moduloApp.vista.InicioCliente;
import moduloApp.modelo.Cliente;

//  Importar para volver al login al cerrar sesion
import moduloLogin.controlador.LoginControl;
import moduloLogin.modelo.Logger;

//  Importar Simulador
import trainSim.controlador.TrainSim;

/**
 *
 * @author David
 */
public class ClienteControl{
    private InicioCliente inicio = new InicioCliente();
    private Logger logger = new Logger();
    private Cliente currentUser;
    private TrainSim ts;
    
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
        inicio.btnRecarga.addActionListener((ActionEvent a) -> {
            inicio.setVisible(false);
            inicio.setVisible(true);
            
        });
        
        /*
        *   Accion del boton Contactenos
        */
        inicio.btnContacto.addActionListener((ActionEvent a) -> {
            inicio.setVisible(false);
            inicio.setVisible(true);
            
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
