package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.dto.ItemCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.admin.RegistroMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DetalleAtencionMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.RegistroAtencionDTO;
import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AdmnistradorServicio;
import co.uniquindio.clinicaLaBienAmada.model.Medico;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.MedicoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServicioMedicoTest {

    @Autowired
    private AdmnistradorServicio admnistradorServicio;

    @Autowired
    private MedicoServicio medicoServicio;


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

    @Test
    @Sql("classpath:dataset.sql")
    public void atencerCita() throws Exception {

        RegistroAtencionDTO atencion = new RegistroAtencionDTO(
                100,
                20,
                "Padece de estres post traumatico",
                "Parcetamol",
                "Semi grave"
        );

        int nuevo = medicoServicio.atenderCita(atencion);

        Assertions.assertNotEquals(0, nuevo);

    }

    @Test
    public void listarAtencionesPaciente() throws Exception {

        List<DetalleAtencionMedicoDTO> lista = medicoServicio.listarHistorialAtencionesPaciente(4);

        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1, lista.size());
    }

    @Test
    public void listarCitasRealizadas() throws Exception {

        List<ItemCitaDTO> lista = medicoServicio.listarCitasRealizadasMedico(24);

        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1, lista.size());
    }

    @Test
    public void verDetalleAtencion() throws Exception {

        DetalleAtencionMedicoDTO detalleAtencion = medicoServicio.verDetalleAtencion(104);

        System.out.println("\n" + "\n" + detalleAtencion.toString());
        Assertions.assertNotEquals(0, detalleAtencion);
    }

    @Test
    public void listarCitasPaciente() throws Exception {

        List<ItemCitaDTO> listaCitas = medicoServicio.listarCitasPaciente(9);

        listaCitas.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1,  + listaCitas.size());
    }

    @Test
    public void listarCitasPendientes() throws Exception {

        List<ItemCitaDTO> lista = medicoServicio.listarCitasPendientes(20);

        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1, lista.size());
    }

    @Test
    public void listarCitasCanceladas() throws Exception {

        List<ItemCitaDTO> lista = medicoServicio.listarCitasCanceladas(20);

        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1, lista.size());
    }
    // ____________________________________________ No Funcionales _______________________________________




}
