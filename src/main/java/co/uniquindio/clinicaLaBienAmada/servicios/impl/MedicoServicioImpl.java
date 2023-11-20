package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.dto.DetalleCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DetalleAtencionMedicoDTO;
import co.uniquindio.clinicaLaBienAmada.dto.ItemCitaDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.DiaLibreDTO;
import co.uniquindio.clinicaLaBienAmada.dto.medico.RegistroAtencionDTO;
import co.uniquindio.clinicaLaBienAmada.model.*;
import co.uniquindio.clinicaLaBienAmada.repositorios.*;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final MedicoRepo medicoRepo;
    private final CitaRepo citaRepo;
    private final AtencionRepo atencionRepo;
    private final HorarioRepo horarioRepo;
    private final DiaLibreRepo diaLibreRepo;
    private final PacienteRepo pacienteRepo;


    // ________________________________ Metodos Funcionales ____________________________________________

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
                cita.getMotivo(),
                cita.getSede(),
                cita.getFechaCita()
        );
    }

    @Override
    public List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception {

        List<Cita> citasMedico = citaRepo.findAllByMedicoCodigo(codigoMedico);
        List<ItemCitaDTO> citasAMostrar = new ArrayList<>();

        for (Cita cita : citasMedico) {
            if(cita.getEstadoCita().equals(EstadoCita.PROGRAMADA)) {
                citasAMostrar.add(new ItemCitaDTO(
                        cita.getCodigo(),
                        cita.getPaciente().getCedula(),
                        cita.getPaciente().getNombre(),
                        cita.getMedico().getNombre(),
                        cita.getMedico().getEspecialidad(),
                        cita.getEstadoCita(),
                        cita.getFechaCita()
                ));
            }
        }


        return citasAMostrar;
    }

    @Override
    public List<ItemCitaDTO> listarCitasCanceladas(int codigoMedico) throws Exception {

        List<Cita> citasMedico = citaRepo.findAllByMedicoCodigo(codigoMedico);
        List<ItemCitaDTO> citasAMostrar = new ArrayList<>();

        for (Cita cita : citasMedico) {
            if(cita.getEstadoCita().equals(EstadoCita.CANCELADA)) {
                citasAMostrar.add(new ItemCitaDTO(
                        cita.getCodigo(),
                        cita.getPaciente().getCedula(),
                        cita.getPaciente().getNombre(),
                        cita.getMedico().getNombre(),
                        cita.getMedico().getEspecialidad(),
                        cita.getEstadoCita(),
                        cita.getFechaCita()
                ));
            }
        }


        return citasAMostrar;
    }

    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {

        Optional<Cita> citaCodigo = citaRepo.findById(registroAtencionDTO.codigoCita());


        if(citaCodigo.isEmpty()){
            throw new Exception("No existe la cita");
        }


        Atencion atencion = new Atencion();

        atencion.setCita( citaCodigo.get() ) ;
        atencion.getCita().setEstadoCita(EstadoCita.COMPLETADA);

        atencion.setNotasMedicas(registroAtencionDTO.notasMedicas());
        atencion.setTratamiento(registroAtencionDTO.tratamiento());
        atencion.setDiagnostico(registroAtencionDTO.diagnostico());

        Atencion atencionNueva = atencionRepo.save(atencion);

        return atencionNueva.getCodigo();
    }

    @Override
    public List<DetalleAtencionMedicoDTO> listarHistorialAtenciones(int codigoCita) throws Exception {

        List<Atencion> atenciones = atencionRepo.findAllByCita_Codigo(codigoCita);

        List<DetalleAtencionMedicoDTO> respuesta = new ArrayList<>();


        for (Atencion detalles : atenciones) {
            respuesta.add(new DetalleAtencionMedicoDTO(
                    detalles.getCita().getCodigo(),
                    detalles.getCita().getPaciente().getNombre(),
                    detalles.getCita().getMedico().getNombre(),
                    detalles.getCita().getMedico().getEspecialidad(),
                    detalles.getCita().getFechaCita(),
                    detalles.getTratamiento(),
                    detalles.getNotasMedicas(),
                    detalles.getDiagnostico()
            ));
        }


        return respuesta;
    }

    @Override
    public List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {

        List<Cita> citas = citaRepo.findAllByMedicoCodigo(codigoMedico);
        List<ItemCitaDTO> citasRealizadas = new ArrayList<>();


        for (Cita cita : citas) {
            if (cita.getEstadoCita().equals(EstadoCita.COMPLETADA)) {
                citasRealizadas.add(new ItemCitaDTO(
                        cita.getCodigo(),
                        cita.getPaciente().getCedula(),
                        cita.getPaciente().getNombre(),
                        cita.getMedico().getNombre(),
                        cita.getMedico().getEspecialidad(),
                        cita.getEstadoCita(),
                        cita.getFechaCita()
                ));
            }
        }

        return citasRealizadas;
    }

    @Override
    public DetalleAtencionMedicoDTO verDetalleAtencion(int codigoCita) throws Exception {

        Optional<Atencion> atencionEncontrada = atencionRepo.findByCitaCodigo(codigoCita);

        if (atencionEncontrada.isEmpty()) {
            throw new Exception("No se pudo encontrar la cita dada el codigo, o tal vez no existe");
        }

        Atencion atencion = atencionEncontrada.get();

        return new DetalleAtencionMedicoDTO(
                atencion.getCita().getCodigo(),
                atencion.getCita().getPaciente().getNombre(),
                atencion.getCita().getMedico().getNombre(),
                atencion.getCita().getMedico().getEspecialidad(),
                atencion.getCita().getFechaCita(),
                atencion.getTratamiento(),
                atencion.getNotasMedicas(),
                atencion.getDiagnostico()
        );
    }

    @Override
    public List<DiaLibreDTO> listarDiaslibres(int codigoMedico) throws Exception {

        List<DiaLibre> diasLibresEncontrados = diaLibreRepo.findAllByMedicoCodigo(codigoMedico);

        List<DiaLibreDTO> respuesta = new ArrayList<>();

        for (DiaLibre d : diasLibresEncontrados){
            respuesta.add(new DiaLibreDTO(
                    d.getCodigo(),
                    d.getDia()
            ));
        }

        return respuesta;
    }
    //_______________________________________________________________________________________________




    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {

        Optional<Medico> optionalMedico = medicoRepo.findById(diaLibreDTO.codigoMedico());

        if(optionalMedico.isEmpty()){
            throw new Exception("No existe el id del médico");
        }

        List<DiaLibre> diasLibres = diaLibreRepo.findAllByMedicoCodigo(diaLibreDTO.codigoMedico());

        List<Cita> citasMedico = citaRepo.findAllByMedicoCodigo(diaLibreDTO.codigoMedico());

        for (Cita cita : citasMedico) {
            if (cita.getFechaCita().equals(diaLibreDTO.dia())) {
                throw new Exception("El dia que intenta agender como libre, ya tiene una cita antes agendada");

            }
        }

        for (DiaLibre diaLibre : diasLibres) {
            if (diaLibreDTO.dia().equals(diaLibre.getDia())) {
                throw new Exception("Este dia ya tiene un dia agendado");
            } else if( diaLibre.getDia().isAfter( LocalDate.now() ) ){
                throw new Exception("Usted ya tiene agendado un día libre para la fecha "+diaLibre.getDia());
            }

        }

        DiaLibre diaLibreMedico = new DiaLibre();
        diaLibreMedico.setDia(diaLibreDTO.dia());
        diaLibreMedico.setMedico(optionalMedico.get());

        diaLibreRepo.save(diaLibreMedico);


        return diaLibreDTO.codigoMedico();
    }

}
