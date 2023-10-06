package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.test.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.test.model.Eps;
import co.uniquindio.clinicaLaBienAmada.test.model.TipoDeSangre;
import co.uniquindio.clinicaLaBienAmada.test.servicios.interfaces.PacienteServicio;
import dto.paciente.RegistroPacienteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ServicioPacienteTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    public void registrarTest() throws Exception {
//Creamos un objeto con los datos del paciente
        RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
                "2478",
                "Darly Daniela",
                "313",
                "xd",
                Ciudad.ARMENIA,
                LocalDate.of(1990, 10, 7).atStartOfDay(),
                "Rinitis",
                Eps.NUEVAEPS,
                TipoDeSangre.A_POSITIVO,
                "correo",
                "asdasd"

        );

//Guardamos el registro usando el método del servicio
        int nuevo = pacienteServicio.registrarse(pacienteDTO);
//Comprobamos que sí haya quedado guardado. Si se guardó debe retornar el código (no 0).
        Assertions.assertNotEquals(0, nuevo);
    }
}
