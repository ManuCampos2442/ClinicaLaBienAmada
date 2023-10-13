package co.uniquindio.clinicaLaBienAmada.repositorios;

import co.uniquindio.clinicaLaBienAmada.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensajeRepo extends JpaRepository<Mensaje, Integer> {


    //List<Mensaje> findAllByCodigo(int codigoMensaje);

    Mensaje findByCodigo(int codigoMensaje);
}

