package co.uniquindio.clinicaLaBienAmada.test.repositorios;

import co.uniquindio.clinicaLaBienAmada.test.model.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRSRepo extends JpaRepository<Pqrs, Integer> {

    List<Pqrs> findAllByCitaPacienteCodigo(int codigoPaciente);

}
