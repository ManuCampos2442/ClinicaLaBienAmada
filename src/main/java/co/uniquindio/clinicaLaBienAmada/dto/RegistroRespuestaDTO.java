package co.uniquindio.clinicaLaBienAmada.dto;

import co.uniquindio.clinicaLaBienAmada.model.Mensaje;

public record RegistroRespuestaDTO(
        int codigoCuenta,
        int codigoPQRS,
        int codigoMensaje,
        String motivo
       // Mensaje mensaje
) {
}
