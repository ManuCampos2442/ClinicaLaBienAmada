package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.dto.admin.RegistroMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AdmnistradorServicio;
import co.uniquindio.clinicaLaBienAmada.model.Medico;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.MedicoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ServicioMedicoTest {

    @Autowired
    private AdmnistradorServicio admnistradorServicio;


    // ________________________________ Funcionales ______________________________________________________
    @Test
    public void crearMedico() throws Exception {

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Charles",
                "333334",
                Ciudad.GONDOR,
                Especialidad.ORTOPEDISTA,
                "32140055",
                "Hol33a@gmail.com",
                "dontdo",
                "URL",
                true,
                new ArrayList<>()

        );

        int nuevo = admnistradorServicio.crearMedico(medicoDTO);

        Assertions.assertNotEquals(0, nuevo);

    }


    // ____________________________________________ No Funcionales _______________________________________


}
