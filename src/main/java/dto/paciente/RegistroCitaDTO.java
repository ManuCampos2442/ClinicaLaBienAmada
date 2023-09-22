package dto.paciente;

import java.time.LocalDateTime;

public record RegistroCitaDTO(
        int codigoPciente,
        LocalDateTime fechaCita,
        int codigoMedico,
        String motivo
) {
}
