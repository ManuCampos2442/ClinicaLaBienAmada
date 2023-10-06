package co.uniquindio.clinicaLaBienAmada.test.servicios.interfaces;

import dto.*;
import dto.paciente.*;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;
    int editarPerfil(int codigoPaciente, RegistroPacienteDTO registroPacienteDTO) throws Exception;
    int eliminarCuenta(int codigoPaciente) throws Exception;
    DetallePacienteDTO verDetallePaciente(int codigo) throws Exception;
    void enviarLinkRecuperacion(String email)throws Exception;
    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;
    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;
    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;


    List<ItemPQRSDTO> listarPQRSPciente(int codigoPciente) throws Exception;

    DetallePQRSDTO verDetallePQRS (int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception;
    DetalleAtencionMedicoDTO verDetalleCita(int codigoCita) throws Exception;

    //-----------OJITO

    void listarPQRSPaciente() throws Exception;
    void responderPQRS() throws Exception;
    void listarCitasPaciente() throws Exception;
    void filtrarCitasPorFecha() throws Exception;
    void filtrarCitasPorMedico() throws Exception;
    void verDetalleCita() throws Exception;


}
