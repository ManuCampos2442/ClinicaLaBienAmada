package co.uniquindio.clinicaLaBienAmada.test.model;

public enum TipoDeSangre {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    AB_POSITIVO("AB+"),
    ABNEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-")
    ;

    private String nombre;

    TipoDeSangre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){return nombre;}
}
