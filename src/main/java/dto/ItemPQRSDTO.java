package dto;

import co.uniquindio.clinicaLaBienAmada.test.model.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivo,
        LocalDateTime fecha,
        String nombrePaciente) {
}
