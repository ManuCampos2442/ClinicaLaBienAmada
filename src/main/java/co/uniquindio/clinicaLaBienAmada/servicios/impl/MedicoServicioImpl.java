package co.uniquindio.clinicaLaBienAmada.servicios.impl;

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

    @Override
    public List<ItemCitaDTO> listarCitasPendientes(int codigoMedico) throws Exception {

        List<Cita> citasMedico = citaRepo.findAllByMedicoCodigo(codigoMedico);
        List<ItemCitaDTO> citasAMostrar = new ArrayList<>();

        for (Cita cita : citasMedico) {
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


        return citasAMostrar;
    }

    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {

        // Optional<Cita> codigoCita = atencionPacienteRepo.findByCitaCodigo(registroAtencionDTO.codigoCita());

        Atencion atencion = new Atencion();
        atencion.getCita().setCodigo(registroAtencionDTO.codigoCita());
        atencion.getCita().getMedico().setCodigo(registroAtencionDTO.codigoMedico());
        atencion.setNotasMedicas(registroAtencionDTO.notasMedicas());
        atencion.setTratamiento(registroAtencionDTO.tratamiento());
        atencion.setDiagnostico(registroAtencionDTO.diagnostico());

        Atencion atencionNueva = atencionRepo.save(atencion);

        return atencionNueva.getCodigo();
    }

    @Override
    public List<DetalleAtencionMedicoDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception {

        List<Atencion> atenciones = atencionRepo.findAllByCodigo(codigoPaciente);

        List<DetalleAtencionMedicoDTO> respuesta = new ArrayList<>();


        for (Atencion detalles : atenciones) {
            respuesta.add(new DetalleAtencionMedicoDTO(
                    detalles.getCodigo(),
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
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO, LocalDate diaAgenda) throws Exception {

        List<DiaLibre> diasLibres = diaLibreRepo.findAllByCodigoMedico(diaLibreDTO.codigoMedico());

        List<Cita> citasMedico = citaRepo.findAllByMedicoCodigo(diaLibreDTO.codigoMedico());

        for (Cita cita : citasMedico) {
            if (cita.getFechaCita().equals(diaLibreDTO.dia())) {
                throw new Exception("El dia que intenta agender como libre, ya tiene una cita antes agendada");

            }
        }

        for (DiaLibre diaLibre : diasLibres) {
            if (diaLibreDTO.dia().equals(diaLibre.getDia())) {
                throw new Exception("Este dia ya tiene un dia agendado");
            } else {
                DiaLibre diaLibreMedico = new DiaLibre();
                diaLibreMedico.setDia(diaLibreDTO.dia());

                diaLibreRepo.save(diaLibreMedico);
                break;


            }
        }

        return diaLibreDTO.codigoMedico();
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
                atencion.getCodigo(),
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
    public List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> citasPacienteEncontradas = citaRepo.findAllByPacienteCodigo(codigoPaciente);

        List<ItemCitaDTO> citas = new ArrayList<>();

        for (Cita c : citasPacienteEncontradas){
            citas.add(new ItemCitaDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getEstadoCita(),
                    c.getFechaCita()
            ));
        }

        return citas;
    }


}
