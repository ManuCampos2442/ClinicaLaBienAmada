package co.uniquindio.clinicaLaBienAmada.test.model;

public enum Especialidad {
    NEUROCIRUJANO("Neurocirujano"),
    ORTOPEDISTA("Ortopedista"),
    CARDIOLOGO("Cardiologo"),
    OTORRINOLARINGOLO("Otorrinolaringologo");

    private String nombre;

    Especialidad(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
