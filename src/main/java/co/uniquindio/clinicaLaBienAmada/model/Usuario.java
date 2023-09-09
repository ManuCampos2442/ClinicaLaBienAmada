package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Usuario {

    //__________________________ Atributos ____________________________________________

    @Id
    private int codigo;

    private String cedula;
    private String nombre;


    private String telefono;
    private String urlFoto;

    //Falta la llave foranea codigoCidudad

    //_________________________________________________________________________________
    //_______________________ Constructor ____________________________________________

    public Usuario (){}

    //_______________________________________________________________________________

}
