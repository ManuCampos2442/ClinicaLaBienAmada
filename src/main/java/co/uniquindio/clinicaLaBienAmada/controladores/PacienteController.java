package co.uniquindio.clinicaLaBienAmada.controladores;

import co.uniquindio.clinicaLaBienAmada.dto.*;
import co.uniquindio.clinicaLaBienAmada.dto.TokenDTO.MensajeDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DetalleAtencionMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.*;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PostMapping("/agendar-cita")
    public ResponseEntity<MensajeDTO<String>> agendarCita(@Valid @RequestBody RegistroCitaDTO registroCitaDTO) throws Exception{
        pacienteServicio.agendarCita(registroCitaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cita agendada correctamente"));
    }

    @PostMapping("/crear-pqrs")
    public ResponseEntity<MensajeDTO<String>> crearPQRS(@Valid @RequestBody RegistroPQRSDTO registroPQRSDTO) throws Exception{
        pacienteServicio.crearPQRS(registroPQRSDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "PQRS creada con exito"));
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.editarPerfil(pacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente actualizado " +
                "correctamete") );
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws
            Exception{
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente eliminado correctamete")
        );
    }

    @GetMapping("/detalle-paciente/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.verDetallePaciente(codigo)) );
    }


    @GetMapping("/listar-pqrs-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemPQRSDTO>>> listarPQRSPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.listarPQRSPciente(codigoPaciente)));
    }

    @GetMapping("/listar-citas-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasPaciente(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.listarCitasPaciente(codigoPaciente)));
    }

    @GetMapping("/detalle-cita/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleCitaDTO>> verDetalleCita(@PathVariable int codigoCita) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.verDetalleCita(codigoCita)));
    }

    @GetMapping("/filtar-cita-fecha/{codigoPaciente}/{fecha}")
    public ResponseEntity<MensajeDTO<List<FiltroBusquedaDTO>>> filtrarCitasPorFecha(@PathVariable int codigoPaciente,  @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate fecha) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.filtrarCitasPorFecha(codigoPaciente, fecha)));
    }

    @GetMapping("/filtar-cita-medico/{codigoPaciente}/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<FiltroBusquedaDTO>>> filtrarCitasPorMedico(@PathVariable int codigoPaciente, @PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.filtrarCitasPorMedico(codigoPaciente, codigoMedico)));
    }

    @GetMapping("/detalle-pqrs/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePQRSDTO>> verDetallePQRS(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.verDetallePQRS(codigo)));
    }


    @PostMapping("/responder-pqrs")
    public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
        pacienteServicio.responderPQRS(registroRespuestaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Mensaje enviado con exito"));
    }

    @GetMapping("/listar-mensajes/{codigoPQRS}/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<RespuestaDTO>>> listarMensajes(@PathVariable int codigoPQRS, @PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.listarMensajes(codigoPQRS, codigoPaciente)));
    }

    @GetMapping("/atenciones/{codigoCita}")
    public ResponseEntity<MensajeDTO<List<DetalleAtencionMedicoDTO>>> listarHistorialAtenciones(@PathVariable int codigoCita) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.listarHistorialAtenciones(codigoCita)));
    }

    @GetMapping("/citas-completadas/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasRealizadas(@PathVariable int codigoPaciente) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.listarCitasCompletadasPaciente(codigoPaciente)));
    }

    @GetMapping("/detalle-atencion/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleAtencionMedicoDTO>> verDetalleAtencion(@PathVariable int codigoCita) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.verDetalleAtencion(codigoCita)));
    }

    @GetMapping("/filtar-atencion-fecha/{codigoPaciente}/{fecha}")
    public ResponseEntity<MensajeDTO<List<DetalleAtencionMedicoDTO>>> filtrarAtencionesPorFecha(@PathVariable int codigoPaciente,  @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate fecha) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.filtrarAtencionesPorFecha(codigoPaciente, fecha)));
    }

    @GetMapping("/filtar-atencion-medico/{codigoPaciente}/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<DetalleAtencionMedicoDTO>>> filtrarAtencionesPorMedico(@PathVariable int codigoPaciente,  @PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                pacienteServicio.filtrarAtencionesPorMedico(codigoPaciente, codigoMedico)));
    }

    /*@GetMapping("/listar-todos")
    public List<ItemPacienteDTO> listarTodos(){
        return pacienteServicio.listarTodos();
    }*/

}
