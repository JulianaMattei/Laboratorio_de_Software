package vacunas;

public class VacunaPatogenoIntegro extends Vacuna {
    private String patogeno;


    /* Forma Incorrecta
    public VacunaPatogenoIntegro(String patogeno) {
        this.patogeno = patogeno;
    }
    */

    public VacunaPatogenoIntegro(String marca, String pais_origen,
                                 String enfermedad_previene, int cantidad_dosis,
                                 String patogeno) {
        super(marca, pais_origen, enfermedad_previene, cantidad_dosis);
        this.patogeno = patogeno;
    }

    public String getPatogeno() {
        return patogeno;
    }

    public void setPatogeno(String patogeno) {
        this.patogeno = patogeno;
    }
}
