package co.uniquindio.clinicaLaBienAmada.model;

public enum EstadoPQR {
    NUEVO("Nuevo"),
    EN_PROCESO("En Proceso"),
    RESUELTO("Resuelto"),
    ARCHIVADO("Archivado");

    private String nombre;

    EstadoPQR(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
