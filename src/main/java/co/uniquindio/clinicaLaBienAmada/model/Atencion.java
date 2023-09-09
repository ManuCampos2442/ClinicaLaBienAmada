package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Atencion implements Serializable {

    @Id
    private int codigo;
    private String diagnostico;
    private String tratamiento;
    private String notasMedicas;

    public Atencion(){}

}
