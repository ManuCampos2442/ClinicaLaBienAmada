package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medico extends Usuario implements Serializable {

    //____________________________________ Atributos ______________________________________________________
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    //_____________________________________________________________________________________________________

    //____________________________________ FK _____________________________________________________________
    @OneToMany(mappedBy = "medico")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "medico")

    private List<DiaLibre> diasLibres;
    //_____________________________________________________________________________________________________

    //___________________________________ Metodo Constructor ______________________________________________
    public Medico() {}
    //_____________________________________________________________________________________________________

}
