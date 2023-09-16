package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {

    //__________________________ Atributos y PK ____________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    //______________________________________________________________________________________

    //__________________________ FK ________________________________________________________
    @ManyToOne
    private Pqrs pqrs;
    @ManyToOne
    private Cuenta cuenta;
    @OneToOne
    private Mensaje mensaje;
    //_________________________________________________________________________________

    //_______________________ Constructor ____________________________________________
    public Mensaje (){}
    //_______________________________________________________________________________
}
