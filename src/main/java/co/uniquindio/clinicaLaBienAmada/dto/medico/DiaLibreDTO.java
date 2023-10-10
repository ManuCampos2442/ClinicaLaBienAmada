package co.uniquindio.clinicaLaBienAmada.dto.medico;

import co.uniquindio.clinicaLaBienAmada.model.Medico;

import java.time.LocalDate;

public record DiaLibreDTO(
        int codigoMedico,
        LocalDate dia
) {
}
