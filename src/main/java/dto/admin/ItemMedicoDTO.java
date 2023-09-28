package dto.admin;

public record ItemMedicoDTO(
        int codigo,
        String nombre,
        String urlFoto,
        String especialidad,
        co.uniquindio.clinicaLaBienAmada.model.Especialidad medicoEspecialidad){
}
