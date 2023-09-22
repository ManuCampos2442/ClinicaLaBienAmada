package dto;

import java.time.LocalDateTime;

public record DetalleAtencionMedicoDTO(
        int codigoCita,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        LocalDateTime fechaAtencion,
        String tratamiento,
        String notasMedicas,
        String diagnostico
) {
}
