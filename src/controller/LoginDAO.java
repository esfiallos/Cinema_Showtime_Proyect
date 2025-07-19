
package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Empleado;


public class LoginDAO {
    
     public Empleado login(String dni, String contrasena) {
    String sql = "SELECT * FROM empleados WHERE dni_empleado = ? AND contrasena = ?";

    try (Connection conn = ConnectionDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, dni);
        ps.setString(2, contrasena);  

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Empleado empleado = new Empleado.Builder()
                        .dniEmpleado(rs.getString("dni_empleado"))
                        .primerNombre(rs.getString("primer_nombre"))
                        .segundoNombre(rs.getString("segundo_nombre"))
                        .primerApellido(rs.getString("primer_apellido"))
                        .segundoApellido(rs.getString("segundo_apellido"))
                        .genero(rs.getString("genero"))
                        .idCine(rs.getInt("id_cine"))
                        .telefonoEmpleado(rs.getString("telefono_empleado"))
                        .contrasena(rs.getString("contrasena"))
                        .build();

                return empleado;
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

        return null; 
    }
}