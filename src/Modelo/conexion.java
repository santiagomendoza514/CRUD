
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;



public class conexion {
    public static final String URL="jdbc:mysql://basedatos-santiagomendozaprb.c6ysxerdawbm.us-east-2.rds.amazonaws.com/Admin_Log"+"?useTimezone=true&serverTimezone=UTC";
    public static final String usuario="root";
    public static final String contraseña="root1234";
    public static Connection conn;    
    PreparedStatement ps;
    ResultSet rs;

     public static Connection getConnection(){
        conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(URL,usuario,contraseña);
            JOptionPane.showMessageDialog(null,"conexion exitosa");
        }catch(Exception ex){
            System.err.println("Error, "+ex);
        }
       
       
         return conn;
    }
/**    
    private final String url = "basedatos-santiagomendozaprb.c6ysxerdawbm.us-east-2.rds.amazonaws.com";
    private final String base = "Admin_Log";
    private final String user = "root";
    private final String password = "root1234";
   
    private Connection con = null;
    
    public Connection getconexion(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);
        }
        catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
**/    
}
