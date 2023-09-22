package dto.paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegistroPacienteDTO(
        String cedula,
        String nombre,
        String telefono,
        String urlFoto,
        int codigoCiudad,
        LocalDate fechaNcimiento,
        String alergias,
        int codigoEps,
        int tipoSangre,
        String correo,
        String password
) {
}
