package co.uniquindio.clinicaLaBienAmada.test.model;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor


public class Administrador extends Cuenta implements Serializable  { }
