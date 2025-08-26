package vacunas;

public class VacunaGenetica extends Vacuna {
    private double temperaturaMinimaAlmacenamiento;
    private double temperaturaMaximaAlmacenamiento;

    /* Forma Incorrecta
    public VacunaGenetica(double temperaturaMaximaAlmacenamiento,
                          double temperaturaMinimaAlmacenamiento) {
        this.temperaturaMaximaAlmacenamiento = temperaturaMaximaAlmacenamiento;
        this.temperaturaMinimaAlmacenamiento = temperaturaMinimaAlmacenamiento;
    }
     */


    public VacunaGenetica(String marca, String pais_origen,
                          String enfermedad_previene, int cantidad_dosis,
                          double temperaturaMaximaAlmacenamiento,
                          double temperaturaMinimaAlmacenamiento) {
        super(marca, pais_origen, enfermedad_previene, cantidad_dosis);
        this.temperaturaMaximaAlmacenamiento = temperaturaMaximaAlmacenamiento;
        this.temperaturaMinimaAlmacenamiento = temperaturaMinimaAlmacenamiento;
    }



    public double getTemperaturaMinimaAlmacenamiento() {
        return temperaturaMinimaAlmacenamiento;
    }

    public void setTemperaturaMinimaAlmacenamiento(double temperaturaMinimaAlmacenamiento) {
        this.temperaturaMinimaAlmacenamiento = temperaturaMinimaAlmacenamiento;
    }

    public double getTemperaturaMaximaAlmacenamiento() {
        return temperaturaMaximaAlmacenamiento;
    }

    public void setTemperaturaMaximaAlmacenamiento(double temperaturaMaximaAlmacenamiento) {
        this.temperaturaMaximaAlmacenamiento = temperaturaMaximaAlmacenamiento;
    }
}
