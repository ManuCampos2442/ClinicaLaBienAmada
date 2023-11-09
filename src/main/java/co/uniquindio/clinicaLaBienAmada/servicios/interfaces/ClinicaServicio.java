package co.uniquindio.clinicaLaBienAmada.servicios.interfaces;

import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Eps;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.model.TipoDeSangre;

import java.util.List;

public interface ClinicaServicio {

    List<Ciudad> listarCiudades();
    List<Especialidad> listarEspecialidades();
    List<TipoDeSangre> listarTiposSangre();
    List<Eps> listarEps();

}