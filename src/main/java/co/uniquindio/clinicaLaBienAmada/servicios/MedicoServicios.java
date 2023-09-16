package co.uniquindio.clinicaLaBienAmada.servicios;

public interface MedicoServicios {

    void listarCitasPacientes();
    void atenderCita();
    void listarCitasPaciente(); //Historial medico
    void agendarDiaLibre();
    void listarCitasRealizadasMedico();
}
