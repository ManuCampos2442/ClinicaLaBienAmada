package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cuenta {

    //__________________________ Atributos ____________________________________________
    @Id
    @GeneratedValue
    private int  idUsuario;
    private String emailusuario;
    private String contrasenia;
    //_________________________________________________________________________________

   // Metodo Constructor
    public Cuenta(){}
    //_________________________________________________________________________________


    //____________________________ Metodos Get and Set _______________________________
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    //_________________________________________________________________________________
}
