package co.uniquindio.clinicaLaBienAmada.servicios.interfaces;

import co.uniquindio.clinicaLaBienAmada.dto.HorarioDTO;
import co.uniquindio.clinicaLaBienAmada.dto.paciente.ItemMedicoPacienteDTO;
import co.uniquindio.clinicaLaBienAmada.model.Ciudad;
import co.uniquindio.clinicaLaBienAmada.model.Eps;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.model.TipoDeSangre;

import java.util.List;

public interface ClinicaServicio {

    List<Ciudad> listarCiudades();
    List<Especialidad> listarEspecialidades();
    List<TipoDeSangre> listarTiposSangre();
    List<Eps> listarEps();

    List<ItemMedicoPacienteDTO> listarMedicoPorEspecialidad(Especialidad especialidad) throws Exception;
    List<HorarioDTO> listarHorariosMedico(int codigoMedico) throws  Exception;
}
