package co.uniquindio.clinicaLaBienAmada.servicios;

import co.uniquindio.clinicaLaBienAmada.model.Medico;
import dto.*;

import java.util.List;

public interface AdmnistradorServicio {

    String crearMedico(MedicoDTO medico) throws Exception;

    String actualizarMedico(int codigo, MedicoDTO medico) throws Exception;

    String eliminarMedico(int codigo) throws Exception;

    List<MedicoDTOAdmin> listarMedicos() throws Exception;

    InfoMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<PQRSDTOAdmin> listarPQRS() throws Exception;

    String responderPQRS(int codigo) throws Exception;

    InfoPQRSDTO verDetallePQRS(int codigo) throws Exception;

    List<CitaDTOAdmin> listarCitas() throws Exception;


}
