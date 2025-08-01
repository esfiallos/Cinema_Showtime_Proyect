package controller;

import bd.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Empleado;

/**
 * Clase DAO que gestiona las operaciones relacionadas con los empleados en la base de datos.
 * Utiliza eliminación lógica (estado ACTIVO/INACTIVO) en lugar de eliminar físicamente registros.
 */
public class EmpleadoDAO {

     /**
     * Obtiene una lista de todos los empleados cuyo estado es 'ACTIVO'.
     *
     * @return Lista de objetos Empleado activos.
     */
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT dni_empleado, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, genero, telefono_empleado, contrasena, estado " +
                     "FROM empleados WHERE estado = 'ACTIVO'";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado.Builder()
                        .dniEmpleado(rs.getString("dni_empleado"))
                        .primerNombre(rs.getString("primer_nombre"))
                        .segundoNombre(rs.getString("segundo_nombre"))
                        .primerApellido(rs.getString("primer_apellido"))
                        .segundoApellido(rs.getString("segundo_apellido"))
                        .genero(rs.getString("genero"))
                        .telefonoEmpleado(rs.getString("telefono_empleado"))
                        .contrasena(rs.getString("contrasena"))
                        .estado(rs.getString("estado"))
                        .build();

                empleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }

    /**
     * Obtiene un empleado específico mediante su DNI.
     *
     * @param dni DNI del empleado que se desea consultar.
     * @return Objeto Empleado si se encuentra, null en caso contrario.
     */
    public Empleado obtenerEmpleadoPorDni(String dni) {
        String sql = "SELECT dni_empleado, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, genero, telefono_empleado, contrasena, estado " +
                     "FROM empleados WHERE dni_empleado = ?";
        Empleado empleado = null;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleado.Builder()
                            .dniEmpleado(rs.getString("dni_empleado"))
                            .primerNombre(rs.getString("primer_nombre"))
                            .segundoNombre(rs.getString("segundo_nombre"))
                            .primerApellido(rs.getString("primer_apellido"))
                            .segundoApellido(rs.getString("segundo_apellido"))
                            .genero(rs.getString("genero"))
                            .telefonoEmpleado(rs.getString("telefono_empleado"))
                            .contrasena(rs.getString("contrasena"))
                            .estado(rs.getString("estado"))
                            .build();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }

    /**
     * Inserta un nuevo empleado en la base de datos con estado inicial 'ACTIVO'.
     *
     * @param empleado Objeto Empleado con los datos a registrar.
     * @return true si la operación fue exitosa, false si ocurrió un error.
     */
    public boolean insertarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleados (dni_empleado, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, genero, telefono_empleado, contrasena, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'ACTIVO')";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empleado.getDniEmpleado());
            ps.setString(2, empleado.getPrimerNombre());
            ps.setString(3, empleado.getSegundoNombre());
            ps.setString(4, empleado.getPrimerApellido());
            ps.setString(5, empleado.getSegundoApellido());
            ps.setString(6, empleado.getGenero());
            ps.setString(7, empleado.getTelefonoEmpleado());
            ps.setString(8, empleado.getContrasena());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza los datos de un empleado existente según su DNI.
     *
     * @param empleado Objeto Empleado con los nuevos datos.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarEmpleado(Empleado empleado) {
        String sql = "UPDATE empleados SET primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, genero = ?, telefono_empleado = ?, contrasena = ? " +
                     "WHERE dni_empleado = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empleado.getPrimerNombre());
            ps.setString(2, empleado.getSegundoNombre());
            ps.setString(3, empleado.getPrimerApellido());
            ps.setString(4, empleado.getSegundoApellido());
            ps.setString(5, empleado.getGenero());
            ps.setString(6, empleado.getTelefonoEmpleado());
            ps.setString(7, empleado.getContrasena());
            ps.setString(8, empleado.getDniEmpleado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Realiza una eliminación lógica de un empleado (cambia su estado a 'INACTIVO').
     *
     * @param dni DNI del empleado a desactivar.
     * @return true si la operación fue exitosa, false si ocurrió un error.
     */
    public boolean desactivarEmpleado(String dni) {
        String sql = "UPDATE empleados SET estado = 'INACTIVO' WHERE dni_empleado = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
