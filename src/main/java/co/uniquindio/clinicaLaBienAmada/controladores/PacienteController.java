package co.uniquindio.clinicaLaBienAmada.controladores;

import co.uniquindio.clinicaLaBienAmada.dto.paciente.DetallePacienteDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.RegistroPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PostMapping("/registrarse")
    public int registrarse(@Valid @RequestBody RegistroPacienteDTO pacienteDTO) throws Exception{
        return 0;
    }
    @PostMapping("/editar_perfil")
    public int editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
        return 0;
    }

    @PostMapping("/eliminar/{codigo}")
    public void eliminarCuenta(@PathVariable int codigo) throws Exception{
    }

    /*@PostMapping("/listar")
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception{
        return null;
    }*/

}
