package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepo extends JpaRepository<Mensaje, Integer> {
}
