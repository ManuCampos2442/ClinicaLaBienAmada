package dto.admin;

import co.uniquindio.clinicaLaBienAmada.test.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.test.model.Especialidad;
import dto.HorarioDTO;

import java.util.List;

public record DetalleMedicoDTO(
        int codigo,
        String nombre,
        String cedula,
        Ciudad ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String urlFoto,
        List<HorarioDTO> horarios

) {

}
