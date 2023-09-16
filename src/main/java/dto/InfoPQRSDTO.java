package dto;

import java.time.LocalDateTime;
import java.util.List;

public record InfoPQRSDTO(
        int codigo,
        String estado,
        int codigoCita,
        String motivo,
        String nombrePaciente,
        LocalDateTime fecha,
        List<String> mensajes

) {
}
