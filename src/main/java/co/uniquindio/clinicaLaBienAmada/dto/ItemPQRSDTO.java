package co.uniquindio.clinicaLaBienAmada.dto;

import co.uniquindio.clinicaLaBienAmada.model.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivo,
        LocalDateTime fecha,
        String nombrePaciente) {
}
