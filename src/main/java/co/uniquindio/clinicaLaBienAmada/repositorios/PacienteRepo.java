package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {

   Paciente findByCedula(String cedula);
   Paciente findByCorreo(String correo);
}
