package dto;

import co.uniquindio.clinicaLaBienAmada.test.model.Mensaje;

public record RegistroRespuestaDTO(
        int codigoCuenta,
        int codigoPQRS,
        Mensaje mensaje
) {
}
