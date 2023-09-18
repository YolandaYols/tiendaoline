/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalpromgramacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinalpromgramacion.ConexionPrueba.BaseDatos;


/**
 *
 * @author luisd
 */
public class Usuarios {

    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private String contrasena;
    
    private String GameVIdeojuegos;
    private String clasificacion;
    private String precio;
    private Double promedio;
    private String Calidad;

    public String getCalidad() {
        return Calidad;
    }

    public void setCalidad(String Calidad) {
        this.Calidad = Calidad;
    }

    public Usuarios(String Calidad) {
        this.Calidad = Calidad;
    }
    
    
    public Usuarios(){
    
    }

    public Usuarios(String GameVIdeojuegos, String clasificacion, String precio, Double promedio) {
        this.GameVIdeojuegos = GameVIdeojuegos;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.promedio = promedio;
    }

    public String getGameVIdeojuegos() {
        return GameVIdeojuegos;
    }

    public void setGameVIdeojuegos(String GameVIdeojuegos) {
        this.GameVIdeojuegos = GameVIdeojuegos;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "GameVIdeojuegos=" + GameVIdeojuegos + ", clasificacion=" + clasificacion + ", precio=" + precio + ", promedio=" + promedio + '}';
    }
    
    

    // Son los datos del usuario que se esta logeando
    public static Usuarios usuarioLogeado = null;

    // Constructor
    public Usuarios(int id, String nombre, String telefono, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    //metodos
    public static boolean login(String correo, String contrasena) {
        Usuarios.usuarioLogeado = null;
        String query = "SELECT * FROM  usuarios_244206 WHERE correo ='" + correo + "' AND contrasena ='" + contrasena + "' ";
        BaseDatos db = new BaseDatos();
        ResultSet rs = db.select(query);

        boolean resultado = false;

        try {
            while (rs.next()) {
                Usuarios.usuarioLogeado = new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("contrasena"));
                resultado = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showInternalMessageDialog(null, "La conexion con la base de datos no pudos er establecida!");

        }
        return resultado;
    }

    
    public static void registrarse(Usuarios u) {
        // " texto " + variable + " mas texto "
        // "+u.getNombre()+"
        String valores = "( '" + u.getNombre() + "','" + u.getTelefono()+ "','" + u.getCorreo() + "','" + u.getContrasena() + "')";
        String consulta = "INSERT INTO usuarios_244206 (nombre, telefono, correo, contrasena) VALUES " + valores;

        BaseDatos db = new BaseDatos();
        System.out.println(consulta);
        db.insert(consulta);

    }

    // Getter and Setter de las variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String direccion) {
        this.telefono = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
