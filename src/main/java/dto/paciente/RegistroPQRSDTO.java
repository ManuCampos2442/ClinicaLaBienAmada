package dto.paciente;

public record RegistroPQRSDTO(
        int codigoCita,
        String motivo,
        int codigoPaciente,
        String tipoPQRS
) {
}
