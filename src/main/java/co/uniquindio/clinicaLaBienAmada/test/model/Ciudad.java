package co.uniquindio.clinicaLaBienAmada.test.model;

public enum Ciudad {

    ARMENIA("Armenia"),
    GONDOR("Gondor"),
    BOGOTA("Bogotoa"),
    MEDELLIN("Medellin"),
    CARTAGENA("Cartagena"),
    ESGAROTH("Esgaroth"),
    DRAENOR("Draenor");

    private String nombre;

    Ciudad(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
