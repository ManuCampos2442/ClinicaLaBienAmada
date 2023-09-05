package co.uniquindio.clinicaLaBienAmada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class EstadoCita implements Serializable {

    //_____________________________________ Atributos ____________________________________________
    @Id
    private int idEstado;
    private String estado;
    //_________________________________________________________________________________

    //______________________________________ Metodo Constructor _______________________
    public EstadoCita(){}
    //_________________________________________________________________________________


    //_____________________________________ Metodo Get and Set ________________________
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //_________________________________________________________________________________
}
