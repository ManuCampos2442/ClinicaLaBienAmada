package dto;

import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.model.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivoPQRS,
        String nombrePaciente,

        Especialidad especialidad,
        LocalDateTime getFecha_Creacion,
        List<RespuestaDTO> mensajes) {
}
