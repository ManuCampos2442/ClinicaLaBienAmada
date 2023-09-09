package co.uniquindio.clinicaLaBienAmada.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
public class DiaLibre implements Serializable {

    @Id

    //PK

    private String codigo;
    
    private String dia;

    //FK

    private String codigoMedico;

    public DiaLibre() {}

}
