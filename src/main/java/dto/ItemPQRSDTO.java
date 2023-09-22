package dto;

import co.uniquindio.clinicaLaBienAmada.model.EstadoPQR;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        int codigo,
        EstadoPQR estado,
        String motivo,
        LocalDateTime fecha,
        String nombrePaciente) {
}
