package co.uniquindio.clinicaLaBienAmada.test;

import co.uniquindio.clinicaLaBienAmada.dto.*;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.*;
import co.uniquindio.clinicaLaBienAmada.model.*;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AutenticacionServicio;
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
import java.util.Random;

@SpringBootTest
public class ServicioPacienteTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private AutenticacionServicio autenticacionServicio;


    // _________________________ Funcionales _________________________________________________
    @Test
    public void crearCita() throws Exception {

        Random random = new Random();

        // Genera un número aleatorio entre 0 y 4
        int numeroAleatorio = random.nextInt(5);

        // Obtén la sede correspondiente al número aleatorio
        Sede sede = Sede.values()[numeroAleatorio];

        RegistroCitaDTO citaDTO = new RegistroCitaDTO(


                        LocalDateTime.of(2023, 10, 10, 14, 30),
                        "Molusco contagioso",
                        EstadoCita.PROGRAMADA,
                         sede,
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


        Random random = new Random();

        // Genera un número aleatorio entre 0 y 4
        int numeroAleatorio = random.nextInt(5);

        // Obtén la sede correspondiente al número aleatorio
        Sede sede = Sede.values()[numeroAleatorio];


        RegistroCitaDTO registroCita = new RegistroCitaDTO(
                LocalDate.of(1990, 10, 7).atStartOfDay(),
                "Consulta General",
                EstadoCita.PROGRAMADA,
                sede,
                9,
                20
        );

        int nuevo = pacienteServicio.agendarCita(registroCita);



        Assertions.assertNotEquals(0, nuevo);
    }


    @Test
    // @Sql("classpath:dataset.sql" )
    public void listarTest() throws Exception {
        //Obtenemos la lista de todos los pacientes
        List<ItemPacienteDTO> lista = pacienteServicio.listarTodos();
        lista.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(8, lista.size());
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

    @Test
    public void filtrarCitasPorCodigoMedico() throws Exception {

        List<FiltroBusquedaDTO> citas = pacienteServicio.filtrarCitasPorMedico(24);

        citas.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1,  + citas.size());
    }

    @Test
    public void filtrarCitasPorFecha() throws Exception {

        List<FiltroBusquedaDTO> citas = pacienteServicio.
                filtrarCitasPorFecha(LocalDate.of(2023, 10, 28).atStartOfDay());

        citas.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(1,  + citas.size());
    }


    @Test
    public void responderPQRS() throws Exception {

        RegistroRespuestaDTO respuesta = new RegistroRespuestaDTO(
                7,
                504,
                "Supremamente grosero el man simplemente cartulina"
        );

        pacienteServicio.responderPQRS(respuesta);

        //Assertions.assertNotEquals(0, respuesta);
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void logear() throws Exception {

        LoginDTO login = new LoginDTO(
                "mariana89@email.com",
                "1234"
        );

        autenticacionServicio.login(login);

        Assertions.assertNotEquals(0, login);

    }

    // _______________________________________________ Funciona pero Ojito ____________________________

    @Test
    public void enviarLinkRecuperacionContrasenia() throws Exception {

        pacienteServicio.enviarLinkRecuperacion("seguridadcopia720@gmail.com");

    }

    @Test
    public void cambiarContrasenia() throws Exception {
        NuevaPasswordDTO nuevaPasswordDTO = new NuevaPasswordDTO(
                9,
                "123"
        );
        System.out.println("nuevaPasswordDTO.nuevaPassword: " + nuevaPasswordDTO.nuevaPassword());
        pacienteServicio.cambiarPassword(nuevaPasswordDTO);
    }

    @Test
    public void filtrarCitas() throws Exception {

        List<FiltroBusquedaDTO> citas = pacienteServicio.filtrarCitas();

        citas.forEach(System.out::println);
        //Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(5,  + citas.size());
    }

    @Test
   // @Transactional
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
