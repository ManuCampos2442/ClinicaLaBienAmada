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
    private LocalDateTime fechaNacimiento;
    private String alergias;

    @Column(nullable = false)
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
