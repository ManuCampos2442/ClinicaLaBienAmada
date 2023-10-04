package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

@Repository
public interface PQRSRepo extends JpaRepository<Pqrs, Integer> {

}
