package co.uniquindio.clinicaLaBienAmada.test.repositorios;

import co.uniquindio.clinicaLaBienAmada.test.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {
}
