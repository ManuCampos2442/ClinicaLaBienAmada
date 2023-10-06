package co.uniquindio.clinicaLaBienAmada.test.repositorios;

import co.uniquindio.clinicaLaBienAmada.test.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepo extends JpaRepository<Mensaje, Integer> {
}
