package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.dto.MedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.admin.DetalleMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.admin.RegistroMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.model.Administrador;
import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AdmnistradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class AdministradorServicioTest {

    @Autowired
    private AdmnistradorServicio admnistradorServicio;


    // _____________________________________ Funcionales _______________________________________________
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


    public void asginarHorario(){

    }

    public void actualizarMedico() throws Exception {

        DetalleMedicoDTO medico = admnistradorServicio.obtenerMedico(22);

        DetalleMedicoDTO medicoModificado = new DetalleMedicoDTO(
                medico.codigo(), medico.nombre(), medico.cedula(), Ciudad.KHAZAD_DUM, medico.especialidad(),
                medico.telefono(), medico.correo(), medico.urlFoto(), medico.horarios());

        admnistradorServicio.actualizarMedico(medicoModificado);
        //admnistradorServicio.actualizarMedico(medicoModificado);

    }


}
