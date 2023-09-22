package co.uniquindio.clinicaLaBienAmada.servicios;

import co.uniquindio.clinicaLaBienAmada.model.Medico;
import dto.*;
import dto.admin.DetalleMedicoDTO;
import dto.admin.ItemMedicoDTO;

import java.util.List;

public interface AdmnistradorServicio {

    String crearMedico(MedicoDTO medico) throws Exception;

    String actualizarMedico(int codigo, MedicoDTO medico) throws Exception;

    String eliminarMedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarMedicos() throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws  Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;


}
