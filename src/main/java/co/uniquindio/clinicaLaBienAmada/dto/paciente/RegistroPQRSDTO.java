package co.uniquindio.clinicaLaBienAmada.dto.paciente;

import co.uniquindio.clinicaLaBienAmada.model.EstadoPQRS;
import co.uniquindio.clinicaLaBienAmada.model.Paciente;

import java.time.LocalDateTime;

public record RegistroPQRSDTO(
        int codigoCita,
        String motivo,
        int codigoPaciente,
        EstadoPQRS estadoPQRS,
        LocalDateTime fechaCreacion,
        String tipo
) {
}
