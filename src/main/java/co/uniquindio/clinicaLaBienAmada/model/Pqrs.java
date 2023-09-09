package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter

public class Pqrs {
    //__________________________ Atributos ____________________________________________

    @Id
    private int codigo;

    private LocalDateTime fecha_Creacion;

    private String tipo;

    private String motivo;

    //Falta la llave foranea de codigoCita
    //Falta la llave foranea de codigoEstado

    //_________________________________________________________________________________

    //_______________________ Constructor ____________________________________________

    public Pqrs(){}

    //_______________________________________________________________________________
}
