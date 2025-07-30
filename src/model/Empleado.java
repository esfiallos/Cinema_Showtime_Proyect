package model;

public class Empleado {

    private String dniEmpleado;       // dni_empleado
    private String primerNombre;      // primer_nombre
    private String segundoNombre;     // segundo_nombre (puede ser null)
    private String primerApellido;    // primer_apellido
    private String segundoApellido;   // segundo_apellido (puede ser null)
    private String genero;            // genero
    private String telefonoEmpleado;  // telefono_empleado
    private String contrasena;        // contrasena
     private String estado;           // estado

    // Getters
    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getGenero() {
        return genero;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public String getContrasena() {
        return contrasena;
    }

    // Método para nombre completo
    public String getNombreCompleto() {
        return primerNombre +
               (segundoNombre != null && !segundoNombre.isEmpty() ? " " + segundoNombre : "") +
               " " + primerApellido +
               (segundoApellido != null && !segundoApellido.isEmpty() ? " " + segundoApellido : "");
    }
    
     public String getEstado() {
        return estado;
    }

    // Setters
    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
     public void setEstado(String estado) {
        this.estado = estado;
    }

   
    private Empleado() {}

    // Builder para facilitar creación de objetos
    public static class Builder {
        private final Empleado empleado;

        public Builder() {
            empleado = new Empleado();
        }

        public Builder dniEmpleado(String dniEmpleado) {
            empleado.setDniEmpleado(dniEmpleado);
            return this;
        }

        public Builder primerNombre(String primerNombre) {
            empleado.setPrimerNombre(primerNombre);
            return this;
        }

        public Builder segundoNombre(String segundoNombre) {
            empleado.setSegundoNombre(segundoNombre);
            return this;
        }

        public Builder primerApellido(String primerApellido) {
            empleado.setPrimerApellido(primerApellido);
            return this;
        }

        public Builder segundoApellido(String segundoApellido) {
            empleado.setSegundoApellido(segundoApellido);
            return this;
        }

        public Builder genero(String genero) {
            empleado.setGenero(genero);
            return this;
        }

        public Builder telefonoEmpleado(String telefonoEmpleado) {
            empleado.setTelefonoEmpleado(telefonoEmpleado);
            return this;
        }

        public Builder contrasena(String contrasena) {
            empleado.setContrasena(contrasena);
            return this;
        }
        
        
        public Builder estado(String estado) {
            empleado.setEstado(estado);
            return this;
        }

        public Empleado build() {
            return empleado;
        }
    }
}
