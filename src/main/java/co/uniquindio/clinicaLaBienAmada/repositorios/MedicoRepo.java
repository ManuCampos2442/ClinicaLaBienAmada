package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {
}
