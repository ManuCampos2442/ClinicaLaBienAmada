package co.uniquindio.clinicaLaBienAmada.test.repositorios;

import co.uniquindio.clinicaLaBienAmada.test.model.Especialidad;
import co.uniquindio.clinicaLaBienAmada.test.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {

    Medico findByCedula(String cedula);

    Medico findByCorreo(String correo);

    List<Medico> findAllByEspecialidad(Especialidad especialidad);


}
