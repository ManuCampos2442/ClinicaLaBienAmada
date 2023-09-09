package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class Mensaje implements Serializable {
//__________________________ Atributos ____________________________________________

    @Id
    private int codigo;

    private LocalDateTime fechaCreacion;

    private String mensaje;

    //Falta la llave foranea de codigo_pqrs
    //Falta la llave foranea de codigo_cuenta
    //Falta la llave foranea de codigo_mensaje

    //_________________________________________________________________________________
    //_______________________ Constructor ____________________________________________

    public Mensaje (){}

    //_______________________________________________________________________________
}
