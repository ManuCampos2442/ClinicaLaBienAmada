package dto;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        String estado,
        String motivoPQRS,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        LocalDateTime fecha,
        List<RespuestaDTO> mensajes) {
}
