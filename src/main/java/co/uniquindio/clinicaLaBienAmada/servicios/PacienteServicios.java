package co.uniquindio.clinicaLaBienAmada.servicios;

public interface PacienteServicios {

    void registrarse() throws Exception;
    void editarPerfil() throws Exception;
    void eliminarCuenta() throws Exception;
    void enviarLinkRecuperacion()throws Exception;
    void cambiarPassword() throws Exception;
    void agendarCita() throws Exception;
    void crearPQRS() throws Exception;
    void listarPQRSPaciente() throws Exception;
    void responderPQRS() throws Exception;
    void listarCitasPaciente() throws Exception;
    void filtrarCitasPorFecha() throws Exception;
    void filtrarCitasPorMedico() throws Exception;
    void verDetalleCita() throws Exception;


}
