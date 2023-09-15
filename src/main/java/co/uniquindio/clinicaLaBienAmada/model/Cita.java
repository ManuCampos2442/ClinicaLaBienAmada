package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {

    //___________________________________ Atributos y PK ______________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false)
    private LocalDateTime fechaCita;
    @Column(nullable = false)
    private String motivo;
    @Column(nullable = false)
    private EstadoCita estadoCita;
    //______________________________________________________________________________________

    //__________________________________ FK ________________________________________________
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    @OneToOne(mappedBy = "cita")
    private Atencion atencion;
    @OneToMany(mappedBy = "cita")
    private List<Pqrs> pqrs;
    //______________________________________________________________________________________

    //_________________________________ Metodo Constructor _________________________________
    public Cita(){}
    //______________________________________________________________________________________
}
