package co.uniquindio.clinicaLaBienAmada.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DiaLibre implements Serializable {


    //____________________________ Atributos y PK __________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private String dia;
    //______________________________________________________________________________________

    //________________________________ FK __________________________________________________
    @ManyToOne
    private Medico medico;
    //______________________________________________________________________________________

    //_______________________________ Metodo Constructor ___________________________________
    public DiaLibre() {}
    //______________________________________________________________________________________

}
