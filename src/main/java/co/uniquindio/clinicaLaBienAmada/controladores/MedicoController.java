package co.uniquindio.clinicaLaBienAmada.controladores;

import co.uniquindio.clinicaLaBienAmada.dto.ItemCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.TokenDTO.MensajeDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DetalleAtencionMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DiaLibreDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.RegistroAtencionDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.RegistroPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.MedicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoServicio medicoServicio;

    @GetMapping("/citas-pendientes/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasPendientes(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                medicoServicio.listarCitasPendientes(codigoMedico)));
    }

    @GetMapping("/citas-realizadas/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasRealizadas(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                medicoServicio.listarCitasRealizadasMedico(codigoMedico)));
    }

    @GetMapping("/citas-canceladas/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasCanceladas(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                medicoServicio.listarCitasCanceladas(codigoMedico)));
    }

    @PostMapping("/atender-cita")
    public ResponseEntity<MensajeDTO<String>> atenderCita(@Valid @RequestBody RegistroAtencionDTO registroAtencionDTO) throws Exception{
        medicoServicio.atenderCita(registroAtencionDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Atención realizada con exito"));
    }

    @GetMapping("/detalle-atencion/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleAtencionMedicoDTO>> verDetalleAtencion(@PathVariable int codigoCita) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                medicoServicio.verDetalleAtencion(codigoCita)));
    }

    @GetMapping("/citas-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                medicoServicio.listarCitasPaciente(codigoPaciente)));
    }


    @GetMapping("/atenciones-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<DetalleAtencionMedicoDTO>>> listarAtencionesPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                medicoServicio.listarHistorialAtencionesPaciente(codigoPaciente)));
    }

    @PostMapping("/agendar-dia-libre")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO) throws Exception{
        medicoServicio.agendarDiaLibre(diaLibreDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Dia libre agendado con exito"));
    }

    @GetMapping("/listar-dias-libres/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<DiaLibreDTO>>> listarDiasLibres(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                medicoServicio.listarDiaslibres(codigoMedico)));
    }

    /*@PostMapping
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroAtencionDTO registroAtencionDTO) throws Exception{
        medicoServicio.atenderCita(registroAtencionDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Atención realizada con exito"));
    }*/
}
