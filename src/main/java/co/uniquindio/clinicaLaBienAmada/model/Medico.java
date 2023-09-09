package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString

public class Medico implements Serializable {

    @Id

    //Pk

    private String codigo;

    //FK
    private String codigoEspecializacion;

    public Medico() {}

}
