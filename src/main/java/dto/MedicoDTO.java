package dto;

import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MedicoDTO(

        int codigo,

        String nombre,
        String cedula,
        Ciudad codigoCiudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String password,
        String URLFoto,
        List<HorarioDTO> horarios

) {
}
