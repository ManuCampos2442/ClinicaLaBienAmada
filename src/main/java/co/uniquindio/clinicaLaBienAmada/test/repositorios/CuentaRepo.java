package co.uniquindio.clinicaLaBienAmada.test.repositorios;

import co.uniquindio.clinicaLaBienAmada.test.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Integer> {
}
