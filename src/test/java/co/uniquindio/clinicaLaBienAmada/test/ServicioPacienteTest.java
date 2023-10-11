package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.dto.DetalleCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.DetallePQRSDTO;
import co.uniquindio.clinicaLaBienAmada.dto.ItemCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.ItemPQRSDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.*;
import co.uniquindio.clinicaLaBienAmada.model.*;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.CitaServicios;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.PacienteServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ServicioPacienteTest {

    @Autowired
    private PacienteServicio pacienteServicio;


    // _________________________ Funcionales _________________________________________________
    @Test
    public void crearCita() throws Exception {

        RegistroCitaDTO citaDTO = new RegistroCitaDTO(


                        LocalDateTime.of(2023, 10, 10, 14, 30),
                        "Molusco contagioso",
                        EstadoCita.PROGRAMADA,
                        9,
                        8

        );


        int nuevo = pacienteServicio.agendarCita(citaDTO);
        int valorEsperado = 1;

        // Verificar que 'nuevo' sea igual al valor esperado
        Assertions.assertEquals(valorEsperado, nuevo);

    }

   @Test
   @Sql("classpath:dataset.sql")
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
                "copiasegu7848@gmail.com",
                "asdasd"
        );

        //Guardamos el registro usando el método del servicio
        int nuevo = pacienteServicio.registrarse(pacienteDTO);
        //Comprobamos que sí haya quedado guardado. Si se guardó debe retornar el código (no 0).
        Assertions.assertNotEquals(0, nuevo);
    }

    @Test
    public void agendarCita() throws Exception {

        RegistroCitaDTO registroCita = new RegistroCitaDTO(
                LocalDate.of(1990, 10, 7).atStartOfDay(),
                "Consulta General",
                EstadoCita.PROGRAMADA,
                9,
                24
        );

        int nuevo = pacienteServicio.agendarCita(registroCita);



        Assertions.assertNotEquals(0, nuevo);
    }

    /* @Test
    public void eliminarPaciente() throws Exception {
        System.out.println("PacienteServicioTest.eliminarPaciente");
        int codigoPaciente = 1;
        boolean eliminado = pacienteServicio.eliminarCuenta(codigoPaciente);


        Assertions.assertTrue(eliminado);
    }*/

    @Test
    // @Sql("classpath:dataset.sql" )
    public void listarTest() throws Exception {
        //Obtenemos la lista de todos los pacientes
        List<ItemPacienteDTO> lista = pacienteServicio.listarTodos();
        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1, lista.size());
    }


    @Test
    public void crearPQRS() throws Exception {

        RegistroPQRSDTO pqrs = new RegistroPQRSDTO(
                1,
                "Me trato muy mal",
                9,
                EstadoPQRS.NUEVO,
                LocalDate.of(1990, 10, 7).atStartOfDay(),
                "Malo"

        );

        int nuevo = pacienteServicio.crearPQRS(pqrs);

        Assertions.assertNotEquals(0, nuevo);
    }

    @Test
    public void verDetallePaciente() throws Exception {


        DetallePacienteDTO detallesDpaciente = pacienteServicio.verDetallePaciente(9);


        System.out.println("\n" + "\n" + detallesDpaciente.toString());
        Assertions.assertNotEquals(0, detallesDpaciente);


    }

    @Test
    public void verDetallePQRS() throws Exception {

        DetallePQRSDTO detallePQRSDTO = pacienteServicio.verDetallePQRS(1);

        System.out.println("\n" + "\n" + detallePQRSDTO.toString());
        Assertions.assertNotEquals(0, detallePQRSDTO);

    }

    @Test
    public void listarCitasPaciente() throws Exception {

        List<ItemCitaDTO> listaCitas = pacienteServicio.listarCitasPaciente(9);

        listaCitas.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1,  + listaCitas.size());
    }

    @Test
    public void verDetalleCita() throws Exception {

        DetalleCitaDTO detalleCita = pacienteServicio.verDetalleCita(1);

        System.out.println("\n" + "\n" + detalleCita.toString());
        Assertions.assertNotEquals(0, detalleCita);

    }

    // _______________________________________________ Funciona pero Ojito ____________________________
    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void actualizarTest() throws Exception{

        DetallePacienteDTO guardado = pacienteServicio.verDetallePaciente(9);

        DetallePacienteDTO modificado = new DetallePacienteDTO(guardado.codigo(),
                guardado.cedula(), guardado.nombre(), guardado.telefono(),
                "Foto", guardado.ciudad(), guardado.fechaNacimiento(),
                guardado.alergias(), guardado.eps(), guardado.tipoSangre(), guardado.correo());

        pacienteServicio.editarPerfil(modificado);


        //  Assertions.assertNotEquals(0, nuevo);

        DetallePacienteDTO objetoModificado = pacienteServicio.verDetallePaciente(9);

        System.out.println(objetoModificado);

        Assertions.assertEquals("Foto" , objetoModificado.urlFoto());
    }

    @Test
    @Transactional
    //@Sql("classpath:dataset.sql")
    public void eliminarTest() throws Exception {
        //Se borra por ejemplo el paciente con el código 1
        pacienteServicio.eliminarCuenta(9);
        //Si intentamos buscar un paciente con el código del paciente borrado debemos obtener una

        Assertions.assertThrows(Exception.class, () -> pacienteServicio.verDetallePaciente(9));
    }

    @Test
    public void listarPQRSPaciente() throws Exception {


        System.out.println(
                "\n" + "\n"
        );

        List<ItemPQRSDTO> lista = pacienteServicio.listarPQRSPciente(9);
        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1,  + lista.size());
    }

    //____________________________________________________________________________________________________
    // ________________________________________________________________________________________________

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void listarTestSQL() throws Exception {

        System.out.println( pacienteServicio.listarTodos() );

    }


   // ________________________________________________________________________________________________








}
