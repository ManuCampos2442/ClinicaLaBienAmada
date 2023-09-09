package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Administrador extends Cuenta implements Serializable  {

    //_______________________ Atributos ____________________________________________
    @Id
    private String idAdministrador;

    //_______________________________________________________________________________
}
