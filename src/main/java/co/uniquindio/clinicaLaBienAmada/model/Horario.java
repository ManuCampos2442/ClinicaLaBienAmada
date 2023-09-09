package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

import java.io.Serializable;



@Entity
@Getter
@Setter
@ToString

public class Horario implements Serializable {


    // ATRIBUTOS ------------------------

    @Id
//PK
     private  String codigo;

     private String dia;

     private String horaInicio;

     private String horaFin;
//FK
     private String codigoMedico;

    public Horario() {}
}
