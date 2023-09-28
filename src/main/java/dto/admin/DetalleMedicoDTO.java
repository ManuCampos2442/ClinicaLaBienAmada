package dto.admin;

import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;

import java.util.ArrayList;

public record DetalleMedicoDTO(
        int codigo, String nombre, String cedula, Ciudad ciudad, Especialidad especialidad, String telefono, String correo, String urlFoto, ArrayList<Object> objects
) {

}
