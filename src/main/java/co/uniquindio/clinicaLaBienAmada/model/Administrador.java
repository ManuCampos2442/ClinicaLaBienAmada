package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter

public class Administrador extends Cuenta implements Serializable  {

    //_______________________ Atributos ____________________________________________
    @Id
    private int codigo;

    //_______________________________________________________________________________

    //_______________________ Constructor ____________________________________________

    public Administrador (){}

    //_______________________________________________________________________________
}
