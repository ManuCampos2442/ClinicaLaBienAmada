package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Eps;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.model.TipoDeSangre;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.ClinicaServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaServicioImpl implements ClinicaServicio {
    @Override
    public List<Ciudad> listarCiudades() {
        return List.of( Ciudad.values() );
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return List.of( Especialidad.values() );
    }

    @Override
    public List<TipoDeSangre> listarTiposSangre() {
        return List.of( TipoDeSangre.values() );
    }

    @Override
    public List<Eps> listarEps() {
        return List.of( Eps.values() );
    }
}
