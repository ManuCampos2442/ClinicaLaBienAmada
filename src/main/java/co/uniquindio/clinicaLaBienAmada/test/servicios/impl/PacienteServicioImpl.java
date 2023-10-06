package co.uniquindio.clinicaLaBienAmada.test.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.test.model.Paciente;
import co.uniquindio.clinicaLaBienAmada.test.repositorios.PacienteRepo;
import co.uniquindio.clinicaLaBienAmada.test.servicios.interfaces.PacienteServicio;
import dto.*;
import dto.paciente.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;

    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {
        if(estaRepetidaCedula_Y_Correo(registroPacienteDTO.cedula(), registroPacienteDTO.correo())){
            throw new Exception("La cedula o el Correo ya se encuentran en uso");
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


        return pacienteNuevo.getCodigo();
    }

    private boolean estaRepetidaCedula_Y_Correo(String cedula, String email) {
        return pacienteRepo.findByCedula(cedula) != null;
    }
    @Override
    public int editarPerfil(int codigoPaciente, RegistroPacienteDTO registroPacienteDTO) throws Exception {
        return 0;
    }

    @Override
    public int eliminarCuenta(int codigoPaciente) throws Exception {
        return 0;
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {
        return null;
    }

    @Override
    public void enviarLinkRecuperacion(String email) throws Exception {

    }

    @Override
    public void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

    }

    @Override
    public int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception {
        return 0;
    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPciente(int codigoPciente) throws Exception {
        return null;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public void filtrarCitas(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception {

    }

    @Override
    public DetalleAtencionMedicoDTO verDetalleCita(int codigoCita) throws Exception {
        return null;
    }

    @Override
    public void listarPQRSPaciente() throws Exception {

    }

    @Override
    public void responderPQRS() throws Exception {

    }

    @Override
    public void listarCitasPaciente() throws Exception {

    }

    @Override
    public void filtrarCitasPorFecha() throws Exception {

    }

    @Override
    public void filtrarCitasPorMedico() throws Exception {

    }

    @Override
    public void verDetalleCita() throws Exception {

    }
}
