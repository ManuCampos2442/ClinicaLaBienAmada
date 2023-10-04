package dto;

import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.model.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivoPQRS,
        String nombrePaciente,
<<<<<<< HEAD
        String nombreMedico,
        Especialidad especialidad,
        LocalDateTime fecha,
=======

        Especialidad especialidad,
        LocalDateTime getFecha_Creacion,
>>>>>>> 6aeeaf5465dafcd2ed95185d272bd081c303688c
        List<RespuestaDTO> mensajes) {
}
