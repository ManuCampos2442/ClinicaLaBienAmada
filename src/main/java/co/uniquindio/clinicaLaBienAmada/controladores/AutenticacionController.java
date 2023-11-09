package co.uniquindio.clinicaLaBienAmada.controladores;


import co.uniquindio.clinicaLaBienAmada.dto.LoginDTO;
import co.uniquindio.clinicaLaBienAmada.dto.TokenDTO.MensajeDTO;
import co.uniquindio.clinicaLaBienAmada.dto.TokenDTO.TokenDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.RegistroPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AutenticacionServicio;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionController {

    private final AutenticacionServicio autenticacionServicio;
    private final PacienteServicio pacienteServicio;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<TokenDTO>> login(@Valid @RequestBody LoginDTO loginDTO)
            throws Exception {

        TokenDTO tokenDTO = autenticacionServicio.login(loginDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
    }

    @PostMapping("/registrar-paciente")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.registrarse(pacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente registrado correctamente"));
    }

    public int registrarPaciente(RegistroPacienteDTO pacienteDTO) throws Exception {
       return pacienteServicio.registrarse(pacienteDTO);
    }
}

