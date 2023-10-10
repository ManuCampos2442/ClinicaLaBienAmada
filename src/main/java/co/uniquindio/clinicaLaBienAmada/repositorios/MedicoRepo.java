package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Cita;
import co.uniquindio.clinicaLaBienAmada.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {

    Medico findByCedula(String cedula);

    Medico findByCorreo(String correo);

    //List<Medico> findByCitas(Cita cita);

    List<Medico> findAllByEspecialidad(Especialidad especialidad);


}
