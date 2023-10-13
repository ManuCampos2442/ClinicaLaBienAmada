package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    List<Cita> findAllByPacienteCodigo(int codigoPaciente);

    List<Cita> findAllByMedicoCodigo(int codigoMedico);

    Cita findCitaByAtencionCodigo(int codigoAtencion);

    List<Cita> findAllByFechaCita(LocalDateTime fecha);

    List<Cita> findAllByMedicoCodigoAndFechaCita(int codigoMedico, LocalDateTime fecha);
}




