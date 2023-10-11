package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtencionRepo extends JpaRepository<Atencion, Integer> {


  //  List<Atencion> findByCitaCodigo(int codigoCita);

    List<Atencion> findAllByCita_Paciente_Codigo(int codigoPaciente);

    Optional<Atencion> findByCitaCodigo(int codigoCita);


}
