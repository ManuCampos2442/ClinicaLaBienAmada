package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Paciente implements Serializable {

    //__________________________ Atributos ____________________________________________

    @Id
    private int codigo;

    private LocalDateTime fechaNacimiento;

    private String alergias;

    private TipoDeSangre tipoDeSangre;

    //Falta la llave foranea de codigo_eps

    //_________________________________________________________________________________

    //_______________________ Constructor ____________________________________________

    public Paciente (){}

    //_______________________________________________________________________________

}
