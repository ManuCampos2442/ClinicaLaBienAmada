package co.uniquindio.clinicaLaBienAmada.servicios.interfaces;

import co.uniquindio.clinicaLaBienAmada.dto.*;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DetalleAtencionMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.*;

import java.time.LocalDateTime;
import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;
    int editarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception;
    boolean eliminarCuenta(int codigoPaciente) throws Exception;
    DetallePacienteDTO verDetallePaciente(int codigo) throws Exception;
   // List<ItemPacienteDTO> listarTodos() throws Exception;
    void enviarLinkRecuperacion(String email)throws Exception;
    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;
    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;
    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;
    List<ItemPQRSDTO> listarPQRSPciente(int codigoPciente) throws Exception;
    DetallePQRSDTO verDetallePQRS (int codigo) throws Exception;
    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;
    List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;
    DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception;
    List<FiltroBusquedaDTO> filtrarCitasPorFecha(int codigoPaciente, LocalDateTime fecha) throws Exception;
    List<FiltroBusquedaDTO> filtrarCitasPorMedico(int codigoPaciente, int codigoMedico) throws Exception;



}
