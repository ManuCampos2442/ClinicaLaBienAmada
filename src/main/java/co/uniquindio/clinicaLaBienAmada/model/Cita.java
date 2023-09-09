package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Cita implements Serializable {

    @Id
    private int codigo;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCita;
    private String motivo;

    public Cita(){}

}
