
package Formularios;

import bd.ConnectionDB;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    
    private static String DNIEmpleado;

    public static String getDNIEmpleado() {
        return DNIEmpleado;
    }

    public static void setDNIEmpleado(String DNIEmpleado) {
        Main.DNIEmpleado = DNIEmpleado;
    }
    
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
