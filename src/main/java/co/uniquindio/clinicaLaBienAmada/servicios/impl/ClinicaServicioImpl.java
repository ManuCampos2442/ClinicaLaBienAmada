package co.uniquindio.clinicaLaBienAmada.servicios.impl;

import co.uniquindio.clinicaLaBienAmada.dto.paciente.ItemMedicoPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.model.*;
import co.uniquindio.clinicaLaBienAmada.repositorios.MedicoRepo;
import co.uniquindio.clinicaLaBienAmada.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicaServicioImpl implements ClinicaServicio {

    private final MedicoRepo medicoRepo;

    @Override
    public List<Ciudad> listarCiudades() {
        return List.of( Ciudad.values() );
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return List.of( Especialidad.values() );
    }

    @Override
    public List<TipoDeSangre> listarTiposSangre() {
        return List.of( TipoDeSangre.values() );
    }

    @Override
    public List<Eps> listarEps() {
        return List.of( Eps.values() );
    }

    @Override
    public List<ItemMedicoPacienteDTO> listarMedicoPorEspecialidad(Especialidad especialidad) throws Exception {

        List<Medico> listaMedicoEspecialidad = medicoRepo.findAllByEspecialidad(especialidad);
        List<ItemMedicoPacienteDTO> respuesta = new ArrayList<>();


        for (Medico m : listaMedicoEspecialidad) {
            respuesta.add(new ItemMedicoPacienteDTO(m.getCodigo(), m.getNombre(),
                    m.getCorreo())
            );
        }

        return respuesta;
    }
}
