
package Formularios;

import bd.ConnectionDB;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Clase principal que inicia la aplicación.
 * Se encarga de preparar la conexión a la base de datos y mostrar la interfaz de login.
 */
public class Main {
    
    private static String DNIEmpleado;

    /**
     * Obtiene el DNI del empleado actualmente logueado.
     * @return DNI del empleado.
     */
    public static String getDNIEmpleado() {
        return DNIEmpleado;
    }

    /**
     * Establece el DNI del empleado actualmente logueado.
     * @param DNIEmpleado DNI del empleado.
     */
    public static void setDNIEmpleado(String DNIEmpleado) {
        Main.DNIEmpleado = DNIEmpleado;
    }
    
    /**
     * Punto de entrada principal de la aplicación.
     * Realiza un precalentamiento de la conexión a la base de datos para mejorar el rendimiento inicial,
     * y luego muestra la ventana de login en el hilo de eventos de Swing.
     * 
     * @param args Argumentos de línea de comando (no utilizados).
     */
    public static void main(String args[] ) {
        
        // Precalentamiento de Hikari
           new Thread(  () -> {
               try {
                   Connection con = ConnectionDB.getConnection();
                   con.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }).start();
           
         //Lamda, ejecucion de Formulario  
        EventQueue.invokeLater( () -> { new Login().setVisible(true); }  );
    }
}
