
package moduloLogin.modelo;

import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

import moduloApp.modelo.Cliente;
import moduloApp.modelo.Trabajador;

/**
 *
 * @author Katherine Ambrosio, Cristhian Hinostroza y David Villacis
 */
public class Logger {
    
    //psql.exe -h ec2-54-158-247-97.compute-1.amazonaws.com -d dajfiu8makf9b7 -U diewcvprxifcwd
    
    private int logAsUserType=-1;
    private int userID=-1;
    
    private final String Driver = "org.postgresql.Driver";//"com.mysql.cj.jdbc.Driver";
    private final String DB_URL = //"jdbc:mysql://localhost/login_info";
              "jdbc:postgresql://ec2-54-158-247-97.compute-1.amazonaws.com:5432" //host:port
              + "/dajfiu8makf9b7";// Base de datos
            
            
    //DB credentials
    private final String USER = //"root";
                                "diewcvprxifcwd";
    private final String PASSW = //"";
                                "d2dedac7a28e306c176f69499f03da57422e4efdb3e2e71b8a0502e157c2c187";
    
    // DB Coneccion
    private Connection conn;
    
    
    public Integer logUser(String user, String password) throws IOException, SQLException, ClassNotFoundException{
        
        getLoginfoDB(user,password);        
    
        return 1;
        // Si regresa 1 significa que se inicio sesion con exito. 0 significa fallo
        
    }
    
    public void conectarDB(String Driver, String DB_URL, String USER, String PASSW){
        //Register JDBC driver
        try{
            Class.forName(Driver);
            System.out.println("Conexion exitosa del driver");
        }catch(ClassNotFoundException e){
            System.out.println("Error en el driver");
        }
        
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSW);
            System.out.println("Conexion exitosa a la DB ");
        }catch(SQLException e){
            System.out.println("Error en la conexion a la DB");
        }
        
    }
    
    private void cerrarDB(){
        try{
            conn.close();
            System.out.println("Conexion cerrada");
        }catch(SQLException e){
            System.out.println("Unable to close connection");
        }
    }
    
    private void getLoginfoDB(String user,String password){
        
        //Coneccion a la tabla de informacion de login
        
        conectarDB(Driver, DB_URL, USER, PASSW);
        
        /*
        *   Ejecutar consulta
        */
        String sql = "SELECT * FROM loginfo WHERE username='"+user+"' AND password = '"+password+"'";
        try{
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                logAsUserType=rs.getInt("usertype");
                userID=rs.getInt("id");
                System.out.println("userID = " + userID);
                //JOptionPane.showMessageDialog(null,"sesion: "+logAsUserType+" id: "+userID);
            }else{
                JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos.");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la consulta SQL");
        }        
        //Cerrar coneccion
        cerrarDB();
    }
    
    public Cliente getClienteInfo(){
        //Coneccion a base de datos de usuarios
        String nombre="-----";
        int dni=0;
        String tarjeta="-----";
        Cliente c;
        
        conectarDB(Driver, DB_URL, USER, PASSW);
        /*
        *   Ejecutar consulta
        */
        
        String sql = "SELECT * FROM clientes WHERE id="+userID+";";
        System.out.println("sql = " + sql);
        try{
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                nombre=rs.getString("nombre");
                dni=rs.getInt("dni");
                tarjeta=rs.getString("tarjeta");
                
            }else{
                System.out.println("no data");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la consulta SQL");
        }
        //Cerrar coneccion
        cerrarDB();
        c = new Cliente(userID,nombre,dni,tarjeta);
        return c;
    }
    
    public Trabajador getTrabajadorInfo(){
        String nombre="-----";
        int dni=0;
        String tarjeta="-----";
        Trabajador t;
        
        //Coneccion a base de datos de usuarios
        conectarDB(Driver, DB_URL, USER, PASSW);
        /*
        *   Ejecutar consulta
        */
        String sql = "SELECT * FROM trabajadores WHERE id="+userID+";";
        try{
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                nombre=rs.getString("nombre");
                dni=rs.getInt("dni");
                tarjeta=rs.getString("tarjeta");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la consulta SQL");
        }
        
        //Cerrar coneccion
        cerrarDB();
        t = new Trabajador(userID,nombre,dni,tarjeta);
        return t;
    }
    
    public void crearUsuario(String nombre, int dni, String usuario, int tipo, String contrasena) throws SQLException{
        int newid;
        String tarjeta = "-";
        conectarDB(Driver, DB_URL, USER, PASSW);
        //Obtener el numero ded usuarios
        String sql = "SELECT COUNT(*) AS usuariosInscritos FROM (SELECT id FROM trabajadores UNION SELECT id FROM clientes) AS tablaCompleta;";
        try{
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                newid = rs.getInt("usuariosInscritos");
                System.out.println("newid = " + newid);
            }else{
                newid=-1;
            }
            
            //Insertar el usuario
            if(tipo==1){
                sql = "INSERT INTO trabajadores VALUES ("+newid+", '"+nombre+"', "+dni+", '"+tarjeta+"');";
            }else{
                sql = "INSERT INTO clientes VALUES ("+newid+", '"+nombre+"', "+dni+", '"+tarjeta+"');";
            }
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Usuario creado con exito");
            
            //Insertar el login
            sql = "INSERT INTO loginfo VALUES ("+newid+",'"+usuario+"', '"+contrasena+"', "+tipo+");";
            s.executeUpdate(sql);
            
        }catch(SQLException e){
            System.out.println("e = " + e.getMessage());
            JOptionPane.showMessageDialog(null,"Error en la consulta SQL");
        }
        
        //Cerrar coneccion
        cerrarDB();
    }

    /**
     * @return the logAsUserType
     */
    public int getUserType() {
        return logAsUserType;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }
    
}
