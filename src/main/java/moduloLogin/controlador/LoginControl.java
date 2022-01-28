
package moduloLogin.controlador;

// Dependencias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
// Modulo actual
import moduloLogin.vista.*;
import moduloLogin.modelo.*;
// Importar siguiente modulo
import moduloApp.controlador.ClienteControl;
import moduloApp.controlador.TrabajadorControl;

/**
 *
 * @author David
 */
public class LoginControl {
    
    private LoginScreen ls = new LoginScreen();
    private String Usuario;
    private String Password;
    private Logger logger = new Logger();
    private Integer loginSuccess=-1;
    
    
    public LoginControl(){
        ls.setVisible(true);
        ls.setLocationRelativeTo(null);
        
        /*
        *   Escuchar al boton iniciar sesion
        */
        ls.btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Usuario = ls.Username.getText();
                Password = new String(ls.Password.getPassword());
                
                try {
                    loginSuccess = logger.logUser(Usuario,Password);
                } catch (IOException | SQLException | ClassNotFoundException ex) {
                    System.out.println("Ha ocurrido un error");
                }
                
                /*
                *   Pasar al siguiente modulo si el login es correcto
                */
                
                if(loginSuccess == 1){
                    switch(logger.getUserType()) {
                        case 0:
                            try {   
                                new ClienteControl(logger.getClienteInfo());
                            } catch (IOException ex) {
                                System.out.println("Error");
                            }break;
                            
                        case 1:
                            try {   
                                new TrabajadorControl(logger.getTrabajadorInfo());
                            } catch (IOException ex) {
                                System.out.println("Error");
                            }break;
                            
                        default:
                            System.out.println("ID: "+logger.getUserID()+" USERTYPE: "+logger.getUserType());
                            break;
                            
                    }
                    ls.dispose();   // Cerrar ventana de login
                    loginSuccess = 0;
                }   
            }
        });
        
        
    }
    
    
}
