package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.dto.*;
import co.uniquindio.clinicaLaBienAmada.dto.admin.DetalleMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.admin.ItemMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.admin.RegistroMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.model.*;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AdmnistradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

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

    public void asginarHorario() {

    }

    @Test
    public void actualizarMedico() throws Exception {

        DetalleMedicoDTO medico = admnistradorServicio.obtenerMedico(22);

        DetalleMedicoDTO medicoModificado = new DetalleMedicoDTO(
                medico.codigo(), medico.nombre(), medico.cedula(), Ciudad.KHAZAD_DUM, medico.especialidad(),
                medico.telefono(), medico.correo(), medico.urlFoto(), medico.horarios());

        admnistradorServicio.actualizarMedico(medicoModificado);


        System.out.println(medicoModificado);

        Assertions.assertEquals(Ciudad.KHAZAD_DUM, medicoModificado.ciudad());

    }

    @Test
    public void listarMedicos() throws Exception {

        System.out.println(
                "\n" + "\n"
        );

        List<ItemMedicoDTO> medicosEncontrados = admnistradorServicio.listarMedicos();

        medicosEncontrados.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(5, +medicosEncontrados.size());
    }

    @Test
    public void listarPQRS() throws Exception {

        System.out.println(
                "\n" + "\n"
        );

        List<ItemPQRSDTO> itemPQRSDTO = admnistradorServicio.listarPQRS();

        itemPQRSDTO.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(5, +itemPQRSDTO.size());
    }

    @Test
    public void verDetallePQRS() throws Exception {

        DetallePQRSDTO pqrs = admnistradorServicio.verDetallePQRS(504);

        System.out.println("\n" + "\n" + pqrs.toString());
        Assertions.assertNotEquals(0, pqrs);
    }

    @Test
    public void listarCitas() throws Exception {

        List<ItemCitaDTO> citas = admnistradorServicio.listarCitas();

        System.out.println(
                "\n" + "\n"
        );

        citas.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(5, +citas.size());

    }

    @Test
    public void cambiarEstadoPQRS() throws Exception {

        admnistradorServicio.cambiarEstadoPQRS(500, EstadoPQRS.RESUELTO);

        //Assertions.assertNotEquals(0, detalleCita);

        //Assertions.assertEquals(EstadoPQRS.RESUELTO , objetoModificado.urlFoto());
    }

    @Test
    public void responderPQRS() throws Exception {

        RegistroRespuestaDTO respuesta = new RegistroRespuestaDTO(
                99,
                504,
                "Pero el doctor me cuenta algo totalmente distinto, que pasa realmente?"
        );

        admnistradorServicio.responderPQRS(respuesta);
    }

    // _________________________________ Funcionales pero con dudas ___________________________________
    @Test
    @Transactional
    public void eliminarMedico() throws Exception {

        admnistradorServicio.eliminarMedico(21);

        Assertions.assertThrows(Exception.class, () -> admnistradorServicio.eliminarMedico(21));


    }

    // ______________________________________________________________________________________________________




}
