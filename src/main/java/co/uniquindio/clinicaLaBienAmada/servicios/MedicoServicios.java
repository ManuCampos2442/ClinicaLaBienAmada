package co.uniquindio.clinicaLaBienAmada.servicios;

public interface MedicoServicios {

    void listarCitasPacientes() throws Exception;

    void atenderCita() throws Exception;

    void listarCitasPaciente() throws Exception; //Historial medico

    void agendarDiaLibre() throws Exception;

    void listarCitasRealizadasMedico() throws Exception;
}
