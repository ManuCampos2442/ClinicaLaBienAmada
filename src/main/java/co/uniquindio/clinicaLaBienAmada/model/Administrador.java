package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Administrador implements Serializable {

    //_______________________ Atributos ____________________________________________
    @Id
    private String idAdministrador;

    private String email;

    private String contrasenia;
    //_______________________________________________________________________________


    //_______________________ Metodo Constructor_____________________________________
    public Administrador(){}
    //_______________________________________________________________________________

    //________________________________ Metodos Get and Set___________________________
    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    //_______________________________________________________________________________
}
