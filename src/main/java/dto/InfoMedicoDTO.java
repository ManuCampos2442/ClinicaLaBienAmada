package dto;

import java.util.List;

public record InfoMedicoDTO(
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