package co.uniquindio.clinicaLaBienAmada.dto;

import java.time.LocalDate;

public record HorarioDTO(LocalDate dia, String horaInicio, String horaSalida) {
}
