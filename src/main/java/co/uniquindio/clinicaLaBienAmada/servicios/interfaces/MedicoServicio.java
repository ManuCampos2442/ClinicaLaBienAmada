package co.uniquindio.clinicaLaBienAmada.servicios.interfaces;

import dto.DetalleAtencionMedicoDTO;
import dto.ItemCitaDTO;
import dto.medico.DiaLibreDTO;
import dto.medico.RegistroAtencionDTO;

import java.util.List;

public interface MedicoServicio {

    List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception;
    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception;
    List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws  Exception;
    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
    DetalleAtencionMedicoDTO verDetalleAtencion(int codigoCita) throws Exception;


    //------------OJITO
    void listarCitasPaciente() throws Exception; //Historial medico

    void agendarDiaLibre() throws Exception;

    void listarCitasRealizadasMedico() throws Exception;
}
