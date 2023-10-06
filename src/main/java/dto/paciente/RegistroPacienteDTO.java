package dto.paciente;

import co.uniquindio.clinicaLaBienAmada.test.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.test.model.Eps;
import co.uniquindio.clinicaLaBienAmada.test.model.TipoDeSangre;

import java.time.LocalDateTime;

public record RegistroPacienteDTO(
        String cedula,
        String nombre,
        String telefono,
        String urlFoto,
        Ciudad codigoCiudad,
        LocalDateTime fechaNcimiento,
        String alergias,
        Eps codigoEps,
        TipoDeSangre tipoSangre,
        String correo,
        String password
) {
}
