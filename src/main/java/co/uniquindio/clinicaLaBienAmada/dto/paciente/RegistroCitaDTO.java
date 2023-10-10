package co.uniquindio.clinicaLaBienAmada.dto.paciente;

import co.uniquindio.clinicaLaBienAmada.model.EstadoCita;

import java.time.LocalDateTime;

public record RegistroCitaDTO(

        LocalDateTime fechaCita,
        String motivo,
        EstadoCita estadoCita,
        int codigoPaciente,
        int codigoMedico

) {

}
