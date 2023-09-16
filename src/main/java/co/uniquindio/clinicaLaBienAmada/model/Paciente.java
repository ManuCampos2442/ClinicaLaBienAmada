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
public class Paciente extends Usuario implements Serializable {

    //__________________________ Atributos y PK ____________________________________________
    @Column(nullable = false)
    private LocalDateTime fechaNacimiento;
    @Column(nullable = false, length = 400)
    private String alergias;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDeSangre tipoDeSangre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Eps eps;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ciudad ciudad;
    // _________________________ FK ________________________________________________________
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
    //_________________________________________________________________________________

    //_______________________ Constructor ____________________________________________
    public Paciente (){}
    //_______________________________________________________________________________

}
