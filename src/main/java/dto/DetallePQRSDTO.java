package dto;

import co.uniquindio.clinicaLaBienAmada.test.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.test.model.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivoPQRS,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        LocalDateTime fecha,
        List<RespuestaDTO> mensajes){

}
