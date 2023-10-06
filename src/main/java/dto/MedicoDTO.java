package dto;

import co.uniquindio.clinicaLaBienAmada.test.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.test.model.Especialidad;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MedicoDTO(

        @NotNull
        int codigo,

        @NotNull
        String nombre,
        @NotNull
        String cedula,
        @NotNull
        Ciudad codigoCiudad,
        @NotNull
        Especialidad especialidad,
        @NotNull
        String telefono,
        @NotNull
        String correo,
        @NotNull
        String password,
        @NotNull
        String URLFoto,
        @NotNull
        List<HorarioDTO> horarios

) {
}
