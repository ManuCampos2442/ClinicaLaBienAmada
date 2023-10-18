package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.dto.*;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DetalleAtencionMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.*;
import co.uniquindio.clinicaLaBienAmada.model.*;
import co.uniquindio.clinicaLaBienAmada.repositorios.*;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.EmailServicio;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final CitaRepo citaRepo;
    private final MedicoRepo medicoRepo;
    private final PQRSRepo pqrsRepo;
    private final CuentaRepo cuentaRepo;
    private final MensajeRepo mensajeRepo;
    private final EmailServicio emailServicio;


    // ___________________________ Metodos Funcionales _______________________________________________
    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {
        if(estaRepetidaCedula(registroPacienteDTO.cedula())){
            throw new Exception("La cedula o el correo ya se encuentran en uso");
        }
        if(estaRepetidoCorreo(registroPacienteDTO.correo())){
            throw new Exception("El Correo ya se encuentran en uso");
        }

        Paciente paciente = new Paciente();
        paciente.setCorreo(registroPacienteDTO.correo());
        paciente.setPassword(registroPacienteDTO.password());

        paciente.setCedula(registroPacienteDTO.cedula());
        paciente.setNombre(registroPacienteDTO.nombre());
        paciente.setTelefono(registroPacienteDTO.telefono());
        paciente.setUrlFoto(registroPacienteDTO.urlFoto());
        paciente.setCiudad(registroPacienteDTO.codigoCiudad());
        paciente.setEstado(true);

        paciente.setFechaNacimiento(registroPacienteDTO.fechaNcimiento());
        paciente.setAlergias(registroPacienteDTO.alergias());
        paciente.setEps(registroPacienteDTO.codigoEps());
        paciente.setTipoDeSangre(registroPacienteDTO.tipoSangre());


        Paciente pacienteNuevo = pacienteRepo.save(paciente);

       emailServicio.enviarCorreo(new EmailDTO(
                paciente.getCorreo(),
                "Bienvenido a la Clinica la Bien Amada",
                "Felicidades, su registro ha sido exitoso. Bienvenido " + paciente.getNombre()
        ));


        return pacienteNuevo.getCodigo();
    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {

        List<Cita> citasAgendadas = citaRepo.findAllByPacienteCodigo(registroCitaDTO.codigoPaciente());
        Optional<Paciente> pacienteObtenido = pacienteRepo.findById(registroCitaDTO.codigoPaciente());
        Optional<Medico> medicoObtenido = medicoRepo.findById(registroCitaDTO.codigoMedico());


        Random random = new Random();

        // Genera un número aleatorio entre 0 y 4
        int numeroAleatorio = random.nextInt(5);

        // Obtén la sede correspondiente al número aleatorio
        Sede sede = Sede.values()[numeroAleatorio];


        Cita cita = new Cita();
        cita.setFechaCita(registroCitaDTO.fechaCita());
        cita.setMotivo(registroCitaDTO.motivo());
        cita.setEstadoCita(registroCitaDTO.estadoCita());
        cita.setSede(sede);

        cita.setPaciente(pacienteObtenido.get());
        cita.setMedico(medicoObtenido.get());

        Cita citaNueva = citaRepo.save(cita);


        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDate fechaCita = citaNueva.getFechaCita().toLocalDate();


        Period periodoHastaCita = Period.between(LocalDate.now(), fechaCita);
        int diasFaltantes = periodoHastaCita.getDays();

        emailServicio.enviarCorreo(new EmailDTO(
                pacienteObtenido.get().getCorreo(),
                "Se ha agendado una nueva cita",
                "La cita se ha agendado con el medico " + cita.getMedico().getNombre() + " el dia "
                + cita.getFechaCita()
        ));

        emailServicio.enviarCorreo(new EmailDTO(
                pacienteObtenido.get().getCorreo(),
                "Faltan " + diasFaltantes + " Dias Para Su Cita",
                "Faltan " + diasFaltantes + " dias para la realizacion de su cita medica." +
                        "Recuerde llevar su documento a la hora de asistir a la cita al igual que un tapabocas."
        ));


        return citaNueva.getCodigo();
    }

    @Override
    public List<ItemPacienteDTO> listarTodos() throws Exception {

        List<Paciente> pacientes = pacienteRepo.findAll();
        List<ItemPacienteDTO> respuesta = new ArrayList<>();

        for (Paciente paciente : pacientes){
            respuesta.add(new ItemPacienteDTO(paciente.getCodigo(), paciente.getCedula(),
                    paciente.getNombre(), paciente.getCiudad()));
        }

        return respuesta;
    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {

        Optional<Cita> citaEncontrada = citaRepo.findById(registroPQRSDTO.codigoCita());

        Pqrs pqrs = new Pqrs();


        pqrs.setMotivo(registroPQRSDTO.motivo());
        pqrs.setCita(citaEncontrada.get());
        pqrs.getCita().getPaciente().setCodigo(registroPQRSDTO.codigoPaciente());
        pqrs.setEstadoPQRS(registroPQRSDTO.estadoPQRS());
        pqrs.setFecha_Creacion(registroPQRSDTO.fechaCreacion());
        pqrs.setTipo(registroPQRSDTO.tipo());

        Pqrs pqrsNueva = pqrsRepo.save(pqrs);



        return pqrsNueva.getCodigo();
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {

        // EL OPCIONAL VA A LA BASE DE DATOS PARA HACER EL IF(PACIENTE -> EXISTE)
        Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigo);

        if (pacienteBuscado.isEmpty()){
            throw new Exception("El paciente que se intenta buscar no existe");
        }

        Paciente paciente = pacienteBuscado.get();

        return new DetallePacienteDTO(paciente.getCodigo(), paciente.getCedula(),
                paciente.getNombre(), paciente.getTelefono(), paciente.getUrlFoto(), paciente.getCiudad(),
                paciente.getFechaNacimiento(), paciente.getAlergias(), paciente.getEps(),
                paciente.getTipoDeSangre(), paciente.getCorreo());
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPciente(int codigoPciente) throws Exception {

        if(existenciaPQRS(codigoPciente).isEmpty()){
            throw new Exception("El paciente con codigo " + codigoPciente + " no tiene PQRS");
        }

        List<Pqrs> pqrs = pqrsRepo.findAllByCita_Paciente_Codigo(codigoPciente);
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for (Pqrs p : pqrs){
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstadoPQRS(),
                    p.getMotivo(),
                    p.getFecha_Creacion(),
                    p.getCita().getPaciente().getNombre()
            ));
        }

        return respuesta;
    }

    @Override
    public List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> citasEncontradas = citaRepo.findAllByPacienteCodigo(codigoPaciente);

        List<ItemCitaDTO> citas = new ArrayList<>();

        for (Cita cita : citasEncontradas){
            citas.add(new ItemCitaDTO(
                    cita.getCodigo(),
                    cita.getPaciente().getCedula(),
                    cita.getPaciente().getNombre(),
                    cita.getMedico().getNombre(),
                    cita.getMedico().getEspecialidad(),
                    cita.getEstadoCita(),
                    cita.getFechaCita()
            ));
        }

        return citas;
    }

    @Override
    public DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception {

        Optional<Cita> citaEncontrada = citaRepo.findById(codigoCita);

        if(citaEncontrada.isEmpty()){
            throw new Exception("No existe tal PQRS con ese codigo");
        }

        Cita cita = citaEncontrada.get();

        return new DetalleCitaDTO(
                cita.getCodigo(),
                cita.getPaciente().getCedula(),
                cita.getPaciente().getNombre(),
                cita.getMedico().getNombre(),
                cita.getMedico().getEspecialidad(),
                cita.getEstadoCita(),
                cita.getFechaCita()
        );
    }

    @Override
    public List<FiltroBusquedaDTO> filtrarCitasPorFecha(LocalDateTime fecha) throws Exception {

        List<Cita> citaEcontradaPorFecha = citaRepo.findAllByFechaCita(fecha);

        if(citaEcontradaPorFecha.isEmpty()){
            throw new Exception("\n No hay tal lista de citas por la fecha introducida.");
        }

        List<FiltroBusquedaDTO> citas = new ArrayList<>();

        for(Cita c : citaEcontradaPorFecha){
            citas.add(new FiltroBusquedaDTO(
                    c.getCodigo(),
                    c.getMedico().getCodigo(),
                    c.getMedico().getNombre(),
                    c.getMotivo(),
                    c.getFechaCita()
            ));
        }

        return citas;

    }

    @Override
    public List<FiltroBusquedaDTO> filtrarCitasPorMedico(int codigoMedico) throws Exception {

        List<Cita> citasEncontradasPorMedico = citaRepo.findAllByMedicoCodigo(codigoMedico);
        List<FiltroBusquedaDTO> citas = new ArrayList<>();

        if(citasEncontradasPorMedico.isEmpty()){
            throw new Exception("\n No hay tal lista de citas por el codigo del medico introducido introducida.");
        }

        for(Cita c : citasEncontradasPorMedico){
            citas.add(new FiltroBusquedaDTO(
                    c.getCodigo(),
                    c.getMedico().getCodigo(),
                    c.getMedico().getNombre(),
                    c.getMotivo(),
                    c.getFechaCita()
            ));
        }

        return citas;
    }

    //____________________________________ Metodo Funcional pero con Dudas ______________________________

    @Override
    public  List<FiltroBusquedaDTO> filtrarCitas() throws Exception {

        List<Cita> citasEncontradas = citaRepo.findAll();
        List<FiltroBusquedaDTO> citas = new ArrayList<>();

        if(citasEncontradas.isEmpty()){
            throw new Exception("No se encontraron citas.");
        }

        for(Cita c : citasEncontradas){
            citas.add(new FiltroBusquedaDTO(
                    c.getCodigo(),
                    c.getMedico().getCodigo(),
                    c.getMedico().getNombre(),
                    c.getMotivo(),
                    c.getFechaCita()
            ));
        }

        return citas;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception {

        Optional<Paciente> pacienteBuscado = pacienteRepo.findById(pacienteDTO.codigo());

        if(pacienteBuscado.isEmpty()){
            throw new Exception("El paciente buscado con codigo " + pacienteDTO.codigo() + " no existe");
        }

        Paciente paciente = pacienteBuscado.get();

        paciente.setCorreo(pacienteDTO.correo());
        paciente.setNombre(pacienteDTO.nombre());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setCiudad(pacienteDTO.ciudad());
        paciente.setUrlFoto(pacienteDTO.urlFoto());

        paciente.setFechaNacimiento( pacienteDTO.fechaNacimiento() );
        paciente.setEps( pacienteDTO.eps() );
        paciente.setAlergias( pacienteDTO.alergias() );
        paciente.setTipoDeSangre( pacienteDTO.tipoSangre() );

        pacienteRepo.save(paciente);

        return paciente.getCodigo();
    }

    @Override
    public boolean eliminarCuenta(int codigoPaciente) throws Exception {

        // EL OPCIONAL VA A LA BASE DE DATOS PARA HACER EL IF(PACIENTE -> EXISTE)
        Optional<Paciente> pacienteBuscado =pacienteRepo.findById(codigoPaciente);

        if( pacienteBuscado.isEmpty() ){
            throw new Exception("No existe el paciente con el código "+codigoPaciente);
        }

        Paciente buscado = pacienteBuscado.get();

        System.out.println("Se va a aliminar el paciente  " + buscado.getNombre());

        buscado.setEstado(false);
        //pacienteRepo.delete(pacienteBuscado.get());
        pacienteRepo.save( buscado );

        return true;

    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {

        Optional<Pqrs> pqrsEncontrada = pqrsRepo.findById(codigo);

        if(pqrsEncontrada.isEmpty()){
            throw new Exception("No existe tal PQRS con ese codigo");
        }

        Pqrs pqrs = pqrsEncontrada.get();

        return new DetallePQRSDTO(
                pqrs.getCodigo(),
                pqrs.getEstadoPQRS(),
                pqrs.getMotivo(),
                pqrs.getCita().getPaciente().getNombre(),
                pqrs.getCita().getMedico().getNombre(),
                pqrs.getCita().getMedico().getEspecialidad(),
                pqrs.getFecha_Creacion(),
                new ArrayList<>()
        );
    }
    //__________________________________________________________________________________________________


    //__________________________________________________________________________________________________

    //_________________________ Metodos de comprobacion ID y Correo desde el repo _________________________
    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
    private boolean estaRepetidoCorreo(String email){
        return pacienteRepo.findByCorreo(email) != null;
    }
    private List<Pqrs> existenciaPQRS(int codigoPciente) { return pqrsRepo.findAllByCita_Paciente_Codigo(codigoPciente);
    }
    //_____________________________________________________________________________________________________




    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

        Optional<Cuenta> optionalCuenta = cuentaRepo.findByCorreo(email);

        if (optionalCuenta.isEmpty()){
            throw new Exception("No existe la cuenta con correo" + email);
        }

        LocalDateTime fecha = LocalDateTime.now();
        String parametro = Base64.getEncoder().encodeToString((optionalCuenta.get().getCodigo()+
                ";"+fecha).getBytes());

        emailServicio.enviarCorreo(new EmailDTO(
                optionalCuenta.get().getCorreo(),
                "Recuperacion de cuenta",
                "Para la recuperacion de la cuenta ingrese al siguiente link https://XXXX" +
                        "/recuperar-password/" + parametro

        ));
    }

    @Override
    public void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

        /*String parametro = new String(Base64.getDecoder().decode(nuevaPasswordDTO.nuevaPassword()));
        String[] datos = parametro.split(";");
        int codigoCuenta = Integer.parseInt(datos[0]);
        LocalDateTime fecha = LocalDateTime.parse(datos[1]);*/

       /* if(fecha.plusMinutes(30).isBefore(LocalDateTime.now())){
            throw new Exception("El link de recuperacion ha expirado");
        }*/

        Cuenta cuenta = obtenerCuentaCodigo(nuevaPasswordDTO.codigoCuenta());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        cuenta.setPassword(passwordEncoder.encode(nuevaPasswordDTO.nuevaPassword()));
        cuentaRepo.save(cuenta);
    }

    private Cuenta obtenerCuentaCodigo(int codigoCuenta) {

        Optional<Cuenta> cuenta = cuentaRepo.findById(codigoCuenta);


        return cuenta.get();
    }


    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        Optional<Pqrs> pqrsEncontrada = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        Optional<Cuenta> cuentaEncontrada = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if(cuentaEncontrada.isEmpty()){
            throw new Exception("El codigo" + registroRespuestaDTO.codigoPQRS() + " no esta asociado a ningun PQRS");
        }

        if(pqrsEncontrada.isEmpty()){
            throw new Exception("No existe tal PQRS con ese codigo");
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setFechaCreacion(LocalDateTime.now());
        mensajeNuevo.setMensaje(registroRespuestaDTO.mensaje());
        mensajeNuevo.setPqrs(pqrsEncontrada.get());
        mensajeNuevo.setCuenta(cuentaEncontrada.get());

        Mensaje mensaje1 = mensajeRepo.save(mensajeNuevo);

        return mensaje1.getCodigo();
    }





}
