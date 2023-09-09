package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cuenta implements Serializable {

    //__________________________ Atributos  y PK ____________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String correo;
    private String password;
    //______________________________________________________________________________________


    //______________________________ FK ____________________________________________________
    @OneToMany(mappedBy = "cuenta")
    private List<Mensaje> mensajes;
    //_________________________________________________________________________________

    //_______________________ Constructor ____________________________________________
    public Cuenta (){}
    //_______________________________________________________________________________
}