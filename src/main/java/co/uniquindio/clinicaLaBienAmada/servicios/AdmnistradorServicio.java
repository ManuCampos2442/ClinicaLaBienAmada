package co.uniquindio.clinicaLaBienAmada.servicios;

import co.uniquindio.clinicaLaBienAmada.model.Medico;

public interface AdmnistradorServicio {

    void crearMedico(Medico medico);

    void actualizarMedico();

    void eliminarMedico();

    void listarMedicos();

    void obtenerMedico();

    void listarPQRS();

    void responderPQRS();

    void verDetallePQRS();

    void listarCitas();

}
