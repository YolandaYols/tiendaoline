package proyectofinalpromgramacion;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Juego {

    private String videojuego;
    private int pieza;
    private double precio;

    private ArrayList<Juego> ListaJuegos = new ArrayList();
    Compras compra = new Compras();

    public Juego(String videojuego, int pieza, double precio) {
        this.videojuego = videojuego;
        this.pieza = pieza;
        this.precio = precio;
    }

    public Juego() {

    }

    public String getVideojuego() {
        return videojuego;
    }

    public int getPieza() {
        return pieza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setVideojuego(String videojuego) {
        this.videojuego = videojuego;
    }

    public void setPieza(int pieza) {
        this.pieza = pieza;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Juego> getListaJuegos() {
        return ListaJuegos;
    }

    public void setListaJuegos(ArrayList<Juego> ListaJuegos) {
        this.ListaJuegos = ListaJuegos;
    }

    DefaultTableModel modelo = new DefaultTableModel();

    public void VideoJuegos(JTable tablaGame) {
        String[] Game = new String[]{"NOMBRE", "PIEZA", "PRECIO"};
        modelo.setColumnIdentifiers(Game);
        tablaGame.setModel(modelo);
    }

    public void RegistroGame(JTextField videojuego, JTextField pieza, JTextField precio) {
        if (videojuego.getText().length() == 0 && pieza.getText().length() == 0 && precio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "LLenar los campos disponibles");
            
        }else{
            this.videojuego=videojuego.getText();
            this.pieza=Integer.parseInt(pieza.getText());
            this.precio= Double.parseDouble(precio.getText());
            modelo.addRow(new Object[]{this.videojuego,this.pieza,this.precio});
            Juego juego = new Juego(this.videojuego,this.pieza,this.precio);
            
            ListaJuegos.add(juego);
            System.out.println("JUEGO AGREGADO");
        }
    }
    
    public void LimpiarDatos(JTextField videojuego, JTextField pieza, JTextField precio,JTable tablaGame){
        videojuego.setText("");
        pieza.setText("");
        precio.setText("");
        
        int fila=tablaGame.getSelectedRow();
        if(tablaGame.getSelectedRow()==-1){
        
            JOptionPane.showMessageDialog(null, "Seleccionar fila");
        }else{
            modelo.removeRow(fila);
        }
    }
    
    

}
