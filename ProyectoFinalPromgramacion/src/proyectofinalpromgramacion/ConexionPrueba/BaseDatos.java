/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpromgramacion.ConexionPrueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisd
 */
public class BaseDatos {
     String usuario ="pitallac_gamesdb";
    String clave="Kanica1*.a";
   // String url ="jdbc:mysql://localhost/tiketsdb?serverTimezone=UTC";
     String url ="jdbc:mysql://termicontrol.mx:3306/pitallac_gamesdb?serverTimezone=UTC";
    Connection con; 
    Statement stmt;
    ResultSet rs;
      

    public BaseDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url,usuario,clave);
            stmt = con.createStatement(); 
        
        
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public  void    insert(String consulta){
        try {
            stmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
                       }
    
    public  ResultSet   select(String consulta){
        try {
            rs = stmt.executeQuery(consulta);
           
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  rs;
    }
  
     
  public static void main(String[] args){  
     
            BaseDatos test = new BaseDatos();
            
          //  test.select("INSERT INTO tecnicos (nombre, apellido, telefono,correo, contrasena) VALUES ('test 5', 't', '677776767', '3sds43@4d77', '123');");
       
            ResultSet rs = test.select( "select * from usuarios_244206; ");
      
            
        try {
            
            while(rs.next()){
                System.out.println(rs.getString("nombre")+ " "+rs.getString("telefono")+ " "+rs.getString("correo")+" "+rs.getString("contrasena") );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
  }
}
