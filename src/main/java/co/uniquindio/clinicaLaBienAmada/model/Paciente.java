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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private LocalDateTime fechaNacimiento;
    private String alergias;
    private TipoDeSangre tipoDeSangre;
    private Ciudad ciudad;
    // _________________________ FK ________________________________________________________
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
    //_________________________________________________________________________________

    //_______________________ Constructor ____________________________________________
    public Paciente (){}
    //_______________________________________________________________________________

}
