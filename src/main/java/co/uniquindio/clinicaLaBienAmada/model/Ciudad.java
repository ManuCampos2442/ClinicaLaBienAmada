package co.uniquindio.clinicaLaBienAmada.model;

public enum Ciudad {

    ARMENIA("Armenia"),
    GONDOR("Gondor"),
    MEDELLIN("Medellin"),
    CARTAGENA("Cartagena"),
    ESGAROTH("Esgaroth"),
    DRAENOR("Draenor"),
    KHAZAD_DUM("Khazad_Dum"),
    MORDOR("Mordor"),

    // SEDES

    GRYFFINDOR("Gryffindor"),

    HUFFLEPUFF(""),
        RAVENCLAW(""),
    SLYTHERIN("Slytherin"),
    LA_CUEVA_DEL_HUMO("La Cueva del Humo");
    private String nombre;

    Ciudad(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
