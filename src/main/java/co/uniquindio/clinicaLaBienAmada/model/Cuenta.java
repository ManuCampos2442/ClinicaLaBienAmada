package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter

public class Cuenta implements Serializable {

    //__________________________ Atributos ____________________________________________

    @Id
    private int codigo;

    private String correo;
    private String password;

    //_________________________________________________________________________________
    //_______________________ Constructor ____________________________________________

    public Cuenta (){}

    //_______________________________________________________________________________
}