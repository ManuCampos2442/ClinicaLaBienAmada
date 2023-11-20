package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.dto.*;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.ItemPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.model.*;
import co.uniquindio.clinicaLaBienAmada.repositorios.*;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AdmnistradorServicio;
import co.uniquindio.clinicaLaBienAmada.dto.admin.DetalleMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.admin.ItemMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.admin.RegistroMedicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorSerivicioImpl implements AdmnistradorServicio {


    private final MedicoRepo medicoRepo;
    private final PacienteRepo pacienteRepo;
    private final PQRSRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final MensajeRepo mensajeRepo;
    private final CuentaRepo cuentaRepo;
    private final HorarioRepo horarioRepo;


    // _________________________________ Metodos Funcionales ___________________________________________

    // UNICAMENTE LAS CLASES QUE IMPLEMENTAN LAS CLASES DE LOS SERVICIOS IMPLEMENTAN EL SERVICE
    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        if (estaRepetidaCedula(medicoDTO.cedula())) {
            throw new Exception("La cedula" + medicoDTO.cedula() + " ya esta en uso");
        }

        if (estaRepetidoCorreo(medicoDTO.correo())) {
            throw new Exception("El correo" + medicoDTO.correo() + " ya esta en uso");
        }


        Medico medico = new Medico();

        medico.setCedula(medicoDTO.cedula());
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre());
        medico.setEspecialidad(medicoDTO.especialidad());
        medico.setCiudad(medicoDTO.ciudad());
        medico.setCorreo(medicoDTO.correo());
        medico.setPassword(medicoDTO.password());
        medico.setUrlFoto(medicoDTO.URLFoto());
        //medico.setEstado(EstadoUsuario.ACTIVO);
        medico.setEstado(true);


        //Solo falta que esto quede guardado y e profe lo vea
        Medico medicoNuevo = medicoRepo.save(medico);

        //c asignarHorariosMedico(medicoNuevo, medicoDTO.horarios());

        return medicoNuevo.getCodigo();
    }

    /*private void asignarHorariosMedico( List<HorarioDTO> horarios, HorarioDTO horarioDTO) {

        Optional<Medico> medicoEncontrado = medicoRepo.findById()
        for(HorarioDTO h: horarios){

            Horario hm = new Horario();
            hm.setDia(h.dia());
            hm.setHoraInicio(h.horaInicio());
            hm.setHoraFin(h.horaSalida());
            hm.setMedico(medicoNuevo);

            horarioRepo.save(hm);
        }
    }*/

    private boolean estaRepetidaCedula(String cedula) {
        return medicoRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findByCorreo(correo) != null;
    }

    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> buscado = medicoRepo.findById(medicoDTO.codigo());

        if (buscado.isEmpty()) {
            throw new Exception("El código " + medicoDTO.cedula() + " no existe");
        }

        Medico medico = buscado.get();
        medico.setCedula(medicoDTO.cedula());
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre());
        medico.setEspecialidad(medicoDTO.especialidad());
        medico.setCiudad(medicoDTO.ciudad());
        medico.setCorreo(medicoDTO.correo());
        medico.setUrlFoto(medicoDTO.urlFoto());

        Medico medicoNuevo = medicoRepo.save(medico);

        return medicoNuevo.getCodigo();
    }

    @Override
    public boolean eliminarMedico(int codigo) throws Exception {

        Optional<Medico> buscado = medicoRepo.findById(codigo); // SELECT * FROM MEDICO WHERE CODIGO = CODIGO

        if (buscado.isEmpty()) {
            throw new Exception("El codigo" + codigo + " no existe mi fai");
        }
        // medicoRepo.delete(buscado.get()); //delete from medico where codigo = codigo

        Medico obtenido = buscado.get();

        obtenido.setEstado(false);
        medicoRepo.save(obtenido);
       // medicoRepo.delete(obtenido);


        return true;
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {

        List<Medico> medicos = medicoRepo.findAll();
        List<ItemMedicoDTO> respuesta = new ArrayList<>();


        if (medicos.isEmpty()) {
            throw new Exception(("No hay medicos registrados"));
        }

        for (Medico medico : medicos) {
            if (medico.isEstado()) {
                respuesta.add(new ItemMedicoDTO(
                        medico.getCodigo(),
                        medico.getCedula(),
                        medico.getNombre(),
                        medico.getUrlFoto(),
                        medico.getEspecialidad()
                ));
            }

        }

        return respuesta;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {

        Optional<Medico> buscado = medicoRepo.findById(codigo); // SELECT * FROM MEDICO WHERE CODIGO = CODIGO

        if (buscado.isEmpty()) {
            throw new Exception("El codigo" + codigo + " no existe mi fai");
        }

        Medico obtenido = buscado.get();

        DetalleMedicoDTO detalleMedicoDTO = new DetalleMedicoDTO(
                obtenido.getCodigo(),
                obtenido.getNombre(),
                obtenido.getCedula(),
                obtenido.getCiudad(),
                obtenido.getEspecialidad(),
                obtenido.getTelefono(),
                obtenido.getCorreo(),
                obtenido.getUrlFoto(),
                new ArrayList<>()
        );
        return detalleMedicoDTO;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

        List<Pqrs> listaPqrs = pqrsRepo.findAll();

        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for (Pqrs p : listaPqrs) {
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstadoPQRS(),
                    p.getMotivo(),
                    p.getFecha_Creacion(),
                    p.getCita().getPaciente().getNombre()
            ));
        }

//        List<ItemPQRSDTO> lista =  listaPqrs.stream().map((m -> new ItemPQRSDTO(
//                p.getCodigo(),
//                p.getEstadoPQRS(),
//                p.getMotivo(),
//                p.getFecha_Creacion(),
//                p.getCita().getPaciente().getNombre()
//        ))).toList();

        return respuesta;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {

        Optional<Pqrs> opcional = pqrsRepo.findById(codigo);

        if (opcional.isEmpty()) {
            throw new Exception("El código " + codigo + " no está asociado a ningún PQRS");
        }

        Pqrs pqrs = opcional.get();

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

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        //Obetener el PQRS
        Optional<Pqrs> opcionalPqrs = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS()); // SELECT * FROM MEDICO WHERE CODIGO = CODIGO
        Optional<Cuenta> cuentaEncontrada = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if (opcionalPqrs.isEmpty()) {
            throw new Exception("El codigo" + registroRespuestaDTO.codigoPQRS() + " no esta asociado a ningun PQRS");
        }

        //Obtener la cuenta / SELECT * FROM MEDICO WHERE CODIGO = CODIGO

        if (cuentaEncontrada.isEmpty()) {
            throw new Exception("El codigo" + registroRespuestaDTO.codigoCuenta() + " no esta asociado a ningun PQRS");
        }


        Mensaje mensaje = new Mensaje();
        mensaje.setFechaCreacion(LocalDate.now());
        mensaje.setMensaje(registroRespuestaDTO.mensaje());
        mensaje.setPqrs(opcionalPqrs.get());
        mensaje.setCuenta(cuentaEncontrada.get());

        return mensajeRepo.save(mensaje).getCodigo();
    }

    @Override
    public int cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {

        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS); // SELECT * FROM MEDICO WHERE CODIGO = CODIGO

        if (opcional.isEmpty()) {
            throw new Exception("El codigo" + codigoPQRS + " no esta asociado a ningun PQRS");
        }

        Pqrs pqrs = opcional.get();
        pqrs.setEstadoPQRS(estadoPQRS);

        pqrsRepo.save(pqrs);

        return pqrs.getCodigo();
    }


    @Override
    public List<ItemCitaDTO> listarCitas() throws Exception {

        List<Cita> listaCitas = citaRepo.findAll();

        List<ItemCitaDTO> respuesta = new ArrayList<>();

        for (Cita c : listaCitas) {
            respuesta.add(new ItemCitaDTO(

                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getEstadoCita(),
                    c.getFechaCita()

            ));


        }

        return respuesta;
    }

    @Override
    public List<ItemPacienteDTO> listarTodos() throws Exception {

        List<Paciente> pacientes = pacienteRepo.findAll();
        List<ItemPacienteDTO> respuesta = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            respuesta.add(new ItemPacienteDTO(paciente.getCodigo(), paciente.getCedula(),
                    paciente.getNombre(), paciente.getCiudad()));
        }

        return respuesta;
    }
}
