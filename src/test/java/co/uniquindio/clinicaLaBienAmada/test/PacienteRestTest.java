package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.dto.LoginDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.DetallePacienteDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.RegistroPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Eps;
import co.uniquindio.clinicaLaBienAmada.model.TipoDeSangre;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PacienteRestTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @Transactional
    public void registrarTest() throws Exception {
        RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
                "1097222222",
                "Pepito Perez",
                "3243434",
                "aquí va la url de la foto",
                Ciudad.ARMENIA,
                LocalDate.of(1990, 10, 7).atStartOfDay(),
                "El polvo y el polen me hacen estornudar",
                Eps.NUEVAEPS,
                TipoDeSangre.A_POSITIVO,
                "pepitoperez@email.com",
                "12345");
        mockMvc.perform(post("/api/auth/registrar-paciente")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());

    }


    @Test
    @Transactional
    public void loginTest() throws Exception {
        LoginDTO loginUser = new LoginDTO("pepitoperez@email.com", "12345");
        mockMvc.perform(post("/api/auth/login")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(loginUser)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    public void verDetalleTest() throws Exception {
        String token = "PEGAR AQUI TOKEN";
        mockMvc.perform(get("/api/pacientes/detalle/{id}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    public void actualizarTest() throws Exception {
        String token = "PEGAR AQUI TOKEN";
        DetallePacienteDTO modificado = new DetallePacienteDTO(
                1,
                "1097222222",
                "Pepito Perez",
                "3243434",
                "aquí va la url de la foto",
                Ciudad.ARMENIA,
                LocalDate.of(1990, 10, 7).atStartOfDay(),
                "El polvo y el polen me hacen estornudar",
                Eps.NUEVAEPS,
                TipoDeSangre.A_POSITIVO,
                "pepitoperez@email.com");
        mockMvc.perform(put("/api/pacientes/editar-perfil")
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(modificado)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    public void eliminarTest() throws Exception {
        String token = "PEGAR AQUI TOKEN";
        mockMvc.perform(delete("/api/pacientes/eliminar/{id}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }
}



