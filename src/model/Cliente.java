
package model;

/**
 *
 * @author Eme
 */
public class Cliente {
    
    
    private String dniCliente;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String genero;
    private String correoCliente;
    private String telefonoCliente;
    private int cineFavorito;


    public String getDniCliente() { return dniCliente; }
    public String getPrimerNombre() {return primerNombre; }
    public String getSegundoNombre() { return segundoNombre;  }
    public String getPrimerApellido() { return primerApellido;}
    public String getSegundoApellido() {  return segundoApellido; }
    public String getGenero() { return genero;  }
    public String getCorreoCliente() {  return correoCliente;}

    
    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }
    public void setPrimerNombre(String primerNombre) {
       this.primerNombre = primerNombre;
    }
     public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
     public void setGenero(String genero) {  
         this.genero = genero; 
     }
     public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;  
     }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
    public void setCineFavorito(int cineFavorito) {
        this.cineFavorito = cineFavorito;
    }
     public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
     
    
    public String getTelefonoCliente() { return telefonoCliente;}
    public int getCineFavorito() {  return cineFavorito;   }
    public String getNombreCompleto() { return primerNombre + " " + segundoNombre; }
    public String getApellidoCompleto() { return primerApellido + " " + segundoApellido; }
    

    public static class Builder {
        private final Cliente cliente;

        public Builder() {
            cliente = new Cliente();
        }

        public Builder setDniCliente(String dniCliente) {
            cliente.setDniCliente(dniCliente);
            return this;
        }

        public Builder setPrimerNombre(String primerNombre) {
            cliente.setPrimerNombre(primerNombre);
            return this;
        }

        public Builder setSegundoNombre(String segundoNombre) {
            cliente.setSegundoNombre(segundoNombre);
            return this;
        }

        public Builder setPrimerApellido(String primerApellido) {
            cliente.setPrimerApellido(primerApellido);
            return this;
        }

        public Builder setSegundoApellido(String segundoApellido) {
            cliente.setSegundoApellido(segundoApellido);
            return this;
        }

        public Builder setGenero(String genero) {
            cliente.setGenero(genero);
            return this;
        }

        public Builder setCorreoCliente(String correoCliente) {
            cliente.setCorreoCliente(correoCliente);
            return this;
        }

        public Builder setTelefonoCliente(String telefonoCliente) {
            cliente.setTelefonoCliente(telefonoCliente);
            return this;
        }

        public Builder setCineFavorito(int cineFavorito) {
            cliente.setCineFavorito(cineFavorito);
            return this;
        }

        public Cliente build() {
            return cliente;
        }
    }
    
}
