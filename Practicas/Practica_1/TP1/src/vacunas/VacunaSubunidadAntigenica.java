package vacunas;

public class VacunaSubunidadAntigenica extends Vacuna {
    private int cantidadAntigenos;
    private String tipoProceso;


    /* Forma Incorrecta
    public VacunaSubunidadAntigenica(int cantidadAntigenos, String tipoProceso) {
        this.cantidadAntigenos = cantidadAntigenos;
        this.tipoProceso = tipoProceso;
    }
    */

    public VacunaSubunidadAntigenica(String marca, String pais_origen,
                                     String enfermedad_previene, int cantidad_dosis,
                                     int cantidadAntigenos, String tipoProceso) {
        super(marca, pais_origen, enfermedad_previene, cantidad_dosis);
        this.cantidadAntigenos = cantidadAntigenos;
        this.tipoProceso = tipoProceso;
    }


    public int getCantidadAntigenos() {
        return cantidadAntigenos;
    }

    public void setCantidadAntigenos(int cantidadAntigenos) {
        this.cantidadAntigenos = cantidadAntigenos;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }
}
