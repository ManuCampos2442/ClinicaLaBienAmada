package co.uniquindio.clinicaLaBienAmada.model;

public enum EstadoPQRS {

    NUEVO("Nuevo"),
    EN_PROCESO("En Proceso"),
    RESUELTO("Resuelto"),
    ARCHIVADO("Archivado");

    private String nombre;

    EstadoPQRS(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
