package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs implements Serializable {


    //__________________________ Atributos y PK ____________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private LocalDateTime fecha_Creacion;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String motivo;
    // _________________________ FK ________________________________________________________
    @ManyToOne
    @Column(nullable = false)
    private Cita cita;

    @OneToMany(mappedBy = "pqrs")
    @Column(nullable = false)
    private List<Mensaje> mensajes;
    //_________________________________________________________________________________

    //_______________________ Constructor ____________________________________________
    public Pqrs(){}
    //_______________________________________________________________________________
}
