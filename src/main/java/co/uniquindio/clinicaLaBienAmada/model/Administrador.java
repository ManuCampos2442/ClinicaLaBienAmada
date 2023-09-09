package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Cuenta implements Serializable  {

    //_______________________ Atributos ____________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    //_______________________________________________________________________________

    //_______________________ Constructor ____________________________________________
    public Administrador (){}
    //_______________________________________________________________________________
}
