package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//WENAS

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Usuario extends  Cuenta implements Serializable {

    //__________________________ Atributos y PK ____________________________________________
    @Column(nullable = false, length = 10, unique = true)
    private String cedula;
    @Column(nullable = false, length = 200)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String telefono;
    @Lob
    @Column(nullable = false)
    private String urlFoto;
    @Column(nullable = false)
    private Ciudad ciudad;
    //_________________________________________________________________________________
    //_______________________ Constructor ____________________________________________
    public Usuario (){}
    //_______________________________________________________________________________

}
