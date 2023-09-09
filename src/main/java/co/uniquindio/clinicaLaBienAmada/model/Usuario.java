package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends  Cuenta implements Serializable {

    //__________________________ Atributos y PK ____________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String cedula;
    private String nombre;
    private String telefono;
    private String urlFoto;
    private Ciudad ciudad;
    //_________________________________________________________________________________
    //_______________________ Constructor ____________________________________________
    public Usuario (){}
    //_______________________________________________________________________________

}
