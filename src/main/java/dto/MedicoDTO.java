package dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MedicoDTO(

        String nombre,
        String cedula,
        int codigoCiudad,
        int especialidad,
        String telefono,
        String correo,
        String password,
        List<HorarioDTO> horarios

) {
}
