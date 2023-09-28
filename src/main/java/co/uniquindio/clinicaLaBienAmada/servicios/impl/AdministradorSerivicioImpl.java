package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.model.Medico;
import co.uniquindio.clinicaLaBienAmada.repositorios.MedicoRepo;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.AdmnistradorServicio;
import dto.*;
import dto.admin.DetalleMedicoDTO;
import dto.admin.ItemMedicoDTO;
import dto.admin.RegistroMedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorSerivicioImpl implements AdmnistradorServicio {


    private final MedicoRepo medicoRepo;

    public AdministradorSerivicioImpl(MedicoRepo medicoRepo) {
        this.medicoRepo = medicoRepo;
    }

    // UNICAMENTE LAS CLASES QUE IMPLEMENTAN LAS CLASES DE LOS SERVICIOS IMPLEMENTAN EL SERVICE
    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        Medico medico = new Medico();
        medico.setCedula(medicoDTO.cedula() );
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre());
        medico.setEspecialidad(medicoDTO.especialidad());
        medico.setCiudad(medicoDTO.codigoCiudad());
        medico.setCorreo(medicoDTO.correo());
        medico.setPassword(medicoDTO.password());
        medico.setUrlFoto(medicoDTO.URLFoto());
        medico.setEstado(true);

        Medico medicoNuevo = medicoRepo.save(medico);

        return medicoNuevo.getCodigo();
    }

    @Override
    public int actualizarMedico(int codigo, MedicoDTO medicoDTO) throws Exception {



        return 0;
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {

       Optional<Medico> buscado = medicoRepo.findById(codigo); // SELECT * FROM MEDICO WHERE CODIGO = CODIGO

        if(buscado.isEmpty()){
            throw new Exception("El codigo" + codigo + " no existe mi fai");
        }
       // medicoRepo.delete(buscado.get()); //delete from medico where codigo = codigo

        Medico obtenido = buscado.get();
        obtenido.setEstado(false);
    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {

        List<Medico> medicos = medicoRepo.findAll();
        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for (Medico medico : medicos){
            if(medico.isEstado()){
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

        if(buscado.isEmpty()){
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
        return null;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {
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
    public List<ItemCitaDTO> listarCitas() throws Exception {
        return null;
    }
}
