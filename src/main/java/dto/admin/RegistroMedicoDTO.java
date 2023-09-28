package dto.admin;

import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import dto.HorarioDTO;

import java.util.List;

public record RegistroMedicoDTO(
        String nombre,
        String cedula,
        Ciudad codigoCiudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String password,
        String URLFoto,
        boolean estado,
        List<HorarioDTO> horarios
) {


}
