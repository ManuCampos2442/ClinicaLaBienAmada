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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cuenta implements Serializable {

    //__________________________ Atributos  y PK ____________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int codigo;

    @Column(nullable = false, unique = true, length = 40)
    private String correo;

    @Column(nullable = false)
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