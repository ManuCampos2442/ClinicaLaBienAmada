package co.uniquindio.clinicaLaBienAmada.controladores;


import co.uniquindio.clinicaLaBienAmada.dto.ItemPQRSDTO;
import co.uniquindio.clinicaLaBienAmada.dto.TokenDTO.MensajeDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.ItemMedicoPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Eps;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.model.TipoDeSangre;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.ClinicaServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinica")
@RequiredArgsConstructor
public class ClinicaController {

    private final ClinicaServicio clinicaServicio;

    @GetMapping("/lista-ciudades")
    public ResponseEntity<MensajeDTO<List<Ciudad>>> listarCiudades(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clinicaServicio.listarCiudades()));
    }

    @GetMapping("/lista-tipo-sangre")
    public ResponseEntity<MensajeDTO<List<TipoDeSangre>>> listarTiposSangre(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clinicaServicio.listarTiposSangre()));
    }

    @GetMapping("/lista-eps")
    public ResponseEntity<MensajeDTO<List<Eps>>> listarEps(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clinicaServicio.listarEps()));
    }

    @GetMapping("/lista-especialidad")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecialidades(){
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clinicaServicio.listarEspecialidades()));
    }

    @GetMapping("/lista-medico-especialidad/{especialidad}")
    public ResponseEntity<MensajeDTO<List<ItemMedicoPacienteDTO>>> listarMedicoPorEspecialidad(
            @PathVariable Especialidad especialidad
    ) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                clinicaServicio.listarMedicoPorEspecialidad(especialidad)));
    }

}
