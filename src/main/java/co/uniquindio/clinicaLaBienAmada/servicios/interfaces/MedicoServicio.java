package co.uniquindio.clinicaLaBienAmada.servicios.interfaces;

import co.uniquindio.clinicaLaBienAmada.dto.DetalleCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DetalleAtencionMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.ItemCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DiaLibreDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.RegistroAtencionDTO;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface MedicoServicio {

    List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception;
    List<ItemCitaDTO> listarCitasCanceladas(int codigoMedico) throws Exception;
    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception;
    List<DetalleAtencionMedicoDTO> listarHistorialAtenciones(int codigoPaciente) throws Exception;
    //List<ItemCitaDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception;
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws  Exception;
    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
    DetalleAtencionMedicoDTO verDetalleAtencion(int codigoCita) throws Exception;
    DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception;
    List<DiaLibreDTO> listarDiaslibres(int codigoMedico) throws Exception;


}
