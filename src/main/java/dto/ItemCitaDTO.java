package dto;

import co.uniquindio.clinicaLaBienAmada.model.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaDTO(
        int codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha
) {
}