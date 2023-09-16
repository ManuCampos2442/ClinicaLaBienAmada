package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {

     //______________________________ Atributos y PK ____________________________________________
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int codigo;
     @Column(nullable = false)
     private String dia;
     @Column(nullable = false)
     private String horaInicio;
     @Column(nullable = false)
     private String horaFin;
     //___________________________________________________________________________________________

     //_______________________________ FK ________________________________________________________
     @ManyToOne
     private Medico medico;
     //___________________________________________________________________________________________

     // ______________________________ Metodo Constructor ________________________________________
    public Horario() {}
     //___________________________________________________________________________________________
}
