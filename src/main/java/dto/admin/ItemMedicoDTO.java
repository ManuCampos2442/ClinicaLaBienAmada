package dto.admin;

import co.uniquindio.clinicaLaBienAmada.test.model.Especialidad;

public record ItemMedicoDTO(
        int codigo,
        String cedula,
        String nombre,
        String urlFoto,
        Especialidad especialidad
    ){
}
