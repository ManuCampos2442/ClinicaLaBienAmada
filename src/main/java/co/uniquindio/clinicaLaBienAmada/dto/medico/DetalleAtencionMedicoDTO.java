package co.uniquindio.clinicaLaBienAmada.dto.medico;

import co.uniquindio.clinicaLaBienAmada.model.Especialidad;

import java.time.LocalDateTime;

public record DetalleAtencionMedicoDTO(
        int codigoCita,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        LocalDateTime fechaAtencion,
        String tratamiento,
        String notasMedicas,
        String diagnostico
) {
}
