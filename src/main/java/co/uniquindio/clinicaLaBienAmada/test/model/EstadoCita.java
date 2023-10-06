package co.uniquindio.clinicaLaBienAmada.test.model;

public enum EstadoCita {
    PROGRAMADA("Programada"),
    COMPLETADA("Completada"),
    CANCELADA("Cancelada");

    private String nombre;

    EstadoCita(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
