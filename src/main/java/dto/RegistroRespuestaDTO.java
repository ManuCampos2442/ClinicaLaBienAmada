package dto;

public record RegistroRespuestaDTO(
        int codigoCuenta,
        int codigoPQRS,
        int codigoMensaje,
        String mensaje
) {
}
